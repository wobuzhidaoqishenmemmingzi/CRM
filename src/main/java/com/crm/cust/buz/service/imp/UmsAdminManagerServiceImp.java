package com.crm.cust.buz.service.imp;

import cn.hutool.core.util.StrUtil;
import com.crm.cust.bo.AdminUserDetails;
import com.crm.cust.buz.service.IUmsAdminManagerService;
import com.crm.cust.comm.helper.UmsAdminLoginLogHelper;
import com.crm.cust.comm.helper.UmsAdminPermissionRelationHelper;
import com.crm.cust.dto.UmsAdminParam;
import com.crm.cust.dto.UpdateAdminPasswordParam;
import com.crm.cust.entity.*;
import com.crm.cust.exception.Asserts;
import com.crm.cust.security.util.JwtTokenUtil;
import com.crm.cust.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UmsAdminManagerServiceImp
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/10、22:30
 * @Version 1.0.0
 */
@Service
public class UmsAdminManagerServiceImp implements IUmsAdminManagerService {

    private final static Logger logger = LoggerFactory.getLogger(UmsAdminManagerServiceImp.class);
    @Autowired
    private IUmsAdminService umsAdminService;
    @Autowired
    private IUmsResourceService umsResourceService;
    @Autowired
    private IUmsRoleService umsRoleService;
    @Autowired
    private IUmsPermissionService umsPermissionService;
    @Autowired
    private IUmsAdminPermissionRelationService umsAdminPermissionRelation;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UmsAdminLoginLogHelper umsAdminLoginLogHelper;
    @Autowired
    private UmsAdminPermissionRelationHelper umsAdminPermissionRelationHelper;
    @Autowired
    private IUmsAdminRoleRelationService umsAdminRoleRelationService;
    @Override
    public AdminUserDetails loadUserByUsername(String username) {
        //获取用户信息
        UmsAdmin admin = umsAdminService.loadUserByUsername(username);
        if (admin != null) {
            List<UmsResource> resourceList = umsResourceService.getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        UmsAdmin umsAdminList = umsAdminService.loadUserByUsername(umsAdmin.getUsername());
        if (null != umsAdminList) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        umsAdminService.save(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            if(!userDetails.isEnabled()){
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
            umsAdminLoginLogHelper.insertLoginLog(username);
        } catch (AuthenticationException e) {
            logger.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public UmsAdmin getItem(Long id) {
        return umsAdminService.getById(id);
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        return umsAdminService.getListLikeUserNamePage(keyword, pageSize, pageNum);
    }

    @Override
    public boolean update(Long id, UmsAdmin admin) {
        admin.setId(id);
        UmsAdmin rawAdmin = umsAdminService.getById(id);
        if(rawAdmin.getPassword().equals(admin.getPassword())){
            //与原加密密码相同的不需要修改
            admin.setPassword(null);
        }else{
            //与原加密密码不同的需要加密修改
            if(StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            }else{
                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            }
        }
        return umsAdminService.updateById(admin);

    }

    @Override
    public boolean delete(Long id) {
        return umsAdminService.removeById(id);
    }

    @Override
    public boolean updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        umsAdminRoleRelationService.removeByAdminId(adminId);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            umsAdminRoleRelationService.saveBatch(list);
        }
        return Boolean.TRUE;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return umsRoleService.getUmsRoleByAdminId(adminId);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = umsResourceService.getResourceList(adminId);
        return resourceList;
    }

    @Override
    public boolean updatePermission(Long adminId, List<Long> permissionIds) {
        //删除原所有权限关系

        umsPermissionService.removeByAdminId(adminId);
        //获取用户所有角色权限
        List<UmsPermission> permissionList = umsPermissionService.getUmsPermissionByAdminId(adminId);
        List<Long> rolePermissionList = permissionList.stream().map(UmsPermission::getId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionIds)) {
            List<UmsAdminPermissionRelation> relationList = new ArrayList<>();
            //筛选出+权限
            List<Long> addPermissionIdList = permissionIds.stream().filter(permissionId -> !rolePermissionList.contains(permissionId)).collect(Collectors.toList());
            //筛选出-权限
            List<Long> subPermissionIdList = rolePermissionList.stream().filter(permissionId -> !permissionIds.contains(permissionId)).collect(Collectors.toList());
            //插入+-权限关系
            relationList.addAll(umsAdminPermissionRelationHelper.convert(adminId,1,addPermissionIdList));
            relationList.addAll(umsAdminPermissionRelationHelper.convert(adminId,-1,subPermissionIdList));
            return umsAdminPermissionRelation.saveBatch(relationList);
        }
        return Boolean.TRUE;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsPermissionService.getUmsPermissionByAdminId(adminId);
    }

    @Override
    public boolean updatePassword(UpdateAdminPasswordParam updatePasswordParam) {
        if(StrUtil.isEmpty(updatePasswordParam.getUsername())
                ||StrUtil.isEmpty(updatePasswordParam.getOldPassword())
                ||StrUtil.isEmpty(updatePasswordParam.getNewPassword())){
            return Boolean.FALSE;
        }
        UmsAdmin admin = umsAdminService.loadUserByUsername(updatePasswordParam.getUsername());
        if(null == admin){
            return Boolean.FALSE;
        }

        if(!passwordEncoder.matches(updatePasswordParam.getOldPassword(), admin.getPassword())){
            return Boolean.FALSE;
        }
        admin.setPassword(passwordEncoder.encode(updatePasswordParam.getNewPassword()));
        umsAdminService.updateById(admin);
        return Boolean.TRUE;
    }

    @Override
    public UmsAdmin getAdminByUsername(String userName) {
        return umsAdminService.loadUserByUsername(userName);
    }
}
