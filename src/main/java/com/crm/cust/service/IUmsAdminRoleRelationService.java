package com.crm.cust.service;

import com.crm.cust.entity.UmsAdminRoleRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsAdminRoleRelationService extends IService<UmsAdminRoleRelation> {

    /**
     * 根据用户名删除后台角色关系
     * @param adminId
     * @return
     */
    boolean removeByAdminId(Long adminId);

    /**
     * 根据用户Id获取后台用户和角色关系
     * @param adminId
     * @return
     */
    List<UmsAdminRoleRelation> getUmsAdminRoleRelationByAdminId(Long adminId);
}
