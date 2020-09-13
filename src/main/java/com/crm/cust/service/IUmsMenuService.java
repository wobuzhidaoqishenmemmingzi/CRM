package com.crm.cust.service;

import com.crm.cust.entity.UmsMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台菜单表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsMenuService extends IService<UmsMenu> {

    /**
     * 根据用户Id 获取菜单信息
     * @param adminId
     * @return
     */
    List<UmsMenu> getUmsMenuByAdminId(Long adminId);

    /**
     * 获取全部后台菜单
     * @return
     */
    List<UmsMenu> getAll();

    /**
     * 根据父级ID 获取菜单 分页
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsMenu> getUmsMenuByParentIdPage(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 根据 角色号 查询 后台菜单信息
     * @param roleId
     * @return
     */
    List<UmsMenu> getUmsMenuByRoleId(Long roleId);

}
