package com.crm.cust.dao;

import com.crm.cust.entity.UmsMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台菜单表 Mapper 接口
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface UmsMenuMapper extends BaseMapper<UmsMenu> {

    /**
     * 根据用户Id 获取菜单信息
     * @param adminId
     * @return
     */
    List<UmsMenu> getUmsMenuByAdminId(@Param("adminId") Long adminId);

    /**
     * 根据 角色号 查询 后台菜单信息
     * @param roleId
     * @return
     */
    List<UmsMenu> getUmsMenuByRoleId(@Param("roleId") Long roleId);
}
