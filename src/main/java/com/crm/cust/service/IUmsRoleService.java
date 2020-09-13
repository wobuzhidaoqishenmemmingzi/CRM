package com.crm.cust.service;

import com.crm.cust.entity.UmsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsRoleService extends IService<UmsRole> {

    /**
     * 根据用户Id 关联后台角色关联表获取借据信息
     * @param adminId
     * @return
     */
    List<UmsRole> getUmsRoleByAdminId(Long adminId);

    /**
     * 根据用户名称获取 后台用户角色信息
     * @param nameKeyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsRole> getUmsRoleByNamePage(String nameKeyword, Integer pageSize, Integer pageNum);
}
