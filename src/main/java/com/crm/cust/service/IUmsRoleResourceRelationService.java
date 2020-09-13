package com.crm.cust.service;

import com.crm.cust.entity.UmsRoleResourceRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台角色资源关系表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsRoleResourceRelationService extends IService<UmsRoleResourceRelation> {

    /**
     * 根据角色号删除 后台角色资源关系
     * @param roleId
     * @return
     */
    boolean removeByRoleId(Long roleId);
}
