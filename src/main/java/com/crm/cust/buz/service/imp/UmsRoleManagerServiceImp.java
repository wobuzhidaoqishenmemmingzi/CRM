package com.crm.cust.buz.service.imp;

import com.crm.cust.buz.service.IUmsRoleManagerService;
import com.crm.cust.entity.*;
import com.crm.cust.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UmsRoleManagerServiceImp
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/13、1:17
 * @Version 1.0.0
 */
@Service
public class UmsRoleManagerServiceImp implements IUmsRoleManagerService {
    private final static Logger logger = LoggerFactory.getLogger(UmsRoleManagerServiceImp.class);

    @Autowired
    private IUmsRoleService umsRoleService;
    @Autowired
    private IUmsRoleResourceRelationService umsRoleResourceRelationService;
    @Autowired
    private IUmsRoleMenuRelationService umsRoleMenuRelationService;
    @Autowired
    private IUmsResourceService umsResourceService;
    @Autowired
    private IUmsMenuService umsMenuService;
    @Autowired
    private IUmsPermissionService umsPermissionService;
    @Autowired
    private IUmsRolePermissionRelationService umsRolePermissionRelationService;
    @Override
    public boolean create(UmsRole role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return umsRoleService.save(role);
    }

    @Override
    public boolean update(Long id, UmsRole role) {
        role.setId(id);
        return umsRoleService.updateById(role);
    }

    @Override
    public boolean delete(List<Long> ids) {
        return umsRoleService.removeByIds(ids);
    }

    @Override
    public List<UmsPermission> getPermissionList(Long roleId) {
        return umsPermissionService.getUmsPermissionByRoleId(roleId);
    }

    @Override
    public boolean updatePermission(Long roleId, List<Long> permissionIds) {
        //先删除原有关系
        umsRolePermissionRelationService.removeByRoleId(roleId);
        //批量插入新关系
        List<UmsRolePermissionRelation> relationList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            UmsRolePermissionRelation relation = new UmsRolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relationList.add(relation);
        }
        return umsRolePermissionRelationService.saveBatch(relationList);
    }

    @Override
    public List<UmsRole> list() {
        return umsRoleService.list();
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        return umsRoleService.getUmsRoleByNamePage(keyword, pageSize, pageNum);
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return umsMenuService.getUmsMenuByAdminId(adminId);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return umsMenuService.getUmsMenuByRoleId(roleId);
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return umsResourceService.getUmsResourceByRoleId(roleId);
    }

    @Override
    public boolean allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        umsRoleMenuRelationService.removerByRoleId(roleId);
        //批量插入新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            umsRoleMenuRelationService.save(relation);
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系

        umsRoleResourceRelationService.removeByRoleId(roleId);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            umsRoleResourceRelationService.save(relation);
        }
        return Boolean.TRUE;
    }
}
