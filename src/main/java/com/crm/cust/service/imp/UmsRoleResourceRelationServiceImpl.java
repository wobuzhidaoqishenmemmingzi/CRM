package com.crm.cust.service.imp;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.crm.cust.dao.UmsRoleResourceRelationMapper;
import com.crm.cust.entity.UmsRoleResourceRelation;
import com.crm.cust.service.IUmsRoleResourceRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台角色资源关系表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsRoleResourceRelationServiceImpl extends ServiceImpl<UmsRoleResourceRelationMapper, UmsRoleResourceRelation> implements IUmsRoleResourceRelationService {

    @Override
    public boolean removeByRoleId(Long roleId) {
        UpdateWrapper<UmsRoleResourceRelation> updateWrapper = new UpdateWrapper<UmsRoleResourceRelation>();
        updateWrapper.eq("ROLE_ID", roleId);
        return this.remove(updateWrapper);
    }
}
