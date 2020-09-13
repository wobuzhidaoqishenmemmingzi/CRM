package com.crm.cust.service.imp;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.crm.cust.dao.UmsRoleMenuRelationMapper;
import com.crm.cust.entity.UmsRoleMenuRelation;
import com.crm.cust.service.IUmsRoleMenuRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台角色菜单关系表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsRoleMenuRelationServiceImpl extends ServiceImpl<UmsRoleMenuRelationMapper, UmsRoleMenuRelation> implements IUmsRoleMenuRelationService {

    @Override
    public boolean removerByRoleId(Long roleId) {
        UpdateWrapper<UmsRoleMenuRelation> updateWrapper = new UpdateWrapper<UmsRoleMenuRelation>();
        updateWrapper.eq("ROLE_ID", roleId);
        return this.remove(updateWrapper);
    }
}
