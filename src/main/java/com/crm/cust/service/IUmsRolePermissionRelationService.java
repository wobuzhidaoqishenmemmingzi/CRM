package com.crm.cust.service;

import com.crm.cust.entity.UmsRolePermissionRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户角色和权限关系表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsRolePermissionRelationService extends IService<UmsRolePermissionRelation> {

    /**
     * 根据 角色id 删除 后台用户角色和权限关系信息
     * @param roleId
     * @return
     */
    boolean removeByRoleId(Long roleId);
}
