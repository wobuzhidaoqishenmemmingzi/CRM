package com.crm.cust.service.imp;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.crm.cust.dao.UmsRolePermissionRelationMapper;
import com.crm.cust.entity.UmsRolePermissionRelation;
import com.crm.cust.service.IUmsRolePermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户角色和权限关系表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsRolePermissionRelationServiceImpl extends ServiceImpl<UmsRolePermissionRelationMapper, UmsRolePermissionRelation> implements IUmsRolePermissionRelationService {

    @Override
    public boolean removeByRoleId(Long roleId) {
        UpdateWrapper<UmsRolePermissionRelation> updateWrapper = new UpdateWrapper<UmsRolePermissionRelation>();
        updateWrapper.eq("ROLE_ID", roleId);
        return this.remove(updateWrapper);
    }
}
