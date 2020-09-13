package com.crm.cust.dao;

import com.crm.cust.entity.UmsRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 Mapper 接口
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface UmsRoleMapper extends BaseMapper<UmsRole> {

    /**
     * 根据用户Id 关联后台角色关联表获取借据信息
     * @param adminId
     * @return
     */
    List<UmsRole> getUmsRoleByAdminId(@Param("adminId") Long adminId);
}
