package com.crm.cust.service;

import com.crm.cust.entity.UmsPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsPermissionService extends IService<UmsPermission> {

    /**
     * 根据用户Id获取后台用户权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getUmsPermissionByAdminId(Long adminId);

    /**
     * 根据用户Id删除后台用户权限表
     * @param adminId
     * @return
     */
    boolean removeByAdminId(Long adminId);

    /**
     * 获取全部后台用户权限信息
     * @return
     */
    List<UmsPermission> getAll();

    /**
     * 根据角色Id 获取 后台用户权限信息
     * @param roleId
     * @return
     */
    List<UmsPermission> getUmsPermissionByRoleId(Long roleId);
}
