package com.crm.cust.service.imp;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.cust.bo.AdminUserDetails;
import com.crm.cust.dao.UmsAdminMapper;
import com.crm.cust.entity.UmsAdmin;
import com.crm.cust.service.IUmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements IUmsAdminService {

    @Override
    public UmsAdmin loadUserByUsername(String username) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<UmsAdmin>();
        queryWrapper.eq("username", username);
        return this.getOne(queryWrapper);
    }

    @Override
    public List<UmsAdmin> getUmsAdminByUserName(String userName) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<UmsAdmin>();
        queryWrapper.eq("username", userName);
        return this.list(queryWrapper);
    }

    @Override
    public List<UmsAdmin> getListLikeUserNamePage(String userName, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<UmsAdmin>();
        queryWrapper.like(StrUtil.isNotBlank(userName), "username", userName);
        return this.list(queryWrapper);
    }
}
