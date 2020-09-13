package com.crm.cust.service;

import com.crm.cust.entity.UmsRoleMenuRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台角色菜单关系表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsRoleMenuRelationService extends IService<UmsRoleMenuRelation> {

    /**
     * 根据角色ID 删除 后台角色菜单关系
     * @param roleId
     * @return
     */
    boolean removerByRoleId(Long roleId);
}
