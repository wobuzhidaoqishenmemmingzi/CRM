package com.crm.cust.dao;

import com.crm.cust.entity.UmsPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 Mapper 接口
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface UmsPermissionMapper extends BaseMapper<UmsPermission> {

    /**
     * 根据用户id 获取 后台用户权限信息
     * @param adminId
     * @return
     */
    List<UmsPermission> getUmsPermissionByAdminId(@Param("adminId") Long adminId);

    /**
     * 根据角色Id 获取 后台用户权限信息
     * @param roleId
     * @return
     */
    List<UmsPermission> getUmsPermissionByRoleId(@Param("roleId") Long roleId);
}
