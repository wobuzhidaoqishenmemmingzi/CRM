package com.crm.cust.service.imp;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.crm.cust.dao.UmsPermissionMapper;
import com.crm.cust.entity.UmsAdminRoleRelation;
import com.crm.cust.entity.UmsPermission;
import com.crm.cust.service.IUmsPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionMapper, UmsPermission> implements IUmsPermissionService {

    @Override
    public List<UmsPermission> getUmsPermissionByAdminId(Long adminId) {
        return this.getBaseMapper().getUmsPermissionByAdminId(adminId);
    }

    @Override
    public boolean removeByAdminId(Long adminId) {
        UpdateWrapper<UmsPermission> updateWrapper = new UpdateWrapper<UmsPermission>();
        updateWrapper.eq("ADMIN_ID", adminId);
        return this.remove(updateWrapper);
    }

    @Override
    public List<UmsPermission> getAll() {
        return this.list();
    }

    @Override
    public List<UmsPermission> getUmsPermissionByRoleId(Long roleId) {
        return this.getBaseMapper().getUmsPermissionByRoleId(roleId);
    }
}
