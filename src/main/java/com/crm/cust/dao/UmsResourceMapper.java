package com.crm.cust.dao;

import com.crm.cust.entity.UmsResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台资源表 Mapper 接口
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface UmsResourceMapper extends BaseMapper<UmsResource> {
    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 根据 角色id 查询 用户所有可访问资源
     * @param roleId
     * @return
     */
    List<UmsResource> getUmsResourceByRoleId(@Param("roleId") Long roleId);
}
