package com.crm.cust.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.crm.cust.dao.UmsAdminRoleRelationMapper;
import com.crm.cust.entity.UmsAdminRoleRelation;
import com.crm.cust.service.IUmsAdminRoleRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsAdminRoleRelationServiceImpl extends ServiceImpl<UmsAdminRoleRelationMapper, UmsAdminRoleRelation> implements IUmsAdminRoleRelationService {

    @Override
    public boolean removeByAdminId(Long adminId) {
        UpdateWrapper<UmsAdminRoleRelation> updateWrapper = new UpdateWrapper<UmsAdminRoleRelation>();
        updateWrapper.eq("ADMIN_ID", adminId);
        return this.remove(updateWrapper);
    }

    @Override
    public List<UmsAdminRoleRelation> getUmsAdminRoleRelationByAdminId(Long adminId) {
        QueryWrapper<UmsAdminRoleRelation> queryWrapper = new QueryWrapper<UmsAdminRoleRelation>();
        queryWrapper.eq("ADMIN_ID", adminId);
        return this.list(queryWrapper);
    }
}
