package com.crm.cust.buz.service;

import com.crm.cust.dto.UmsMenuNode;
import com.crm.cust.entity.UmsMenu;

import java.util.List;

public interface IUmsMenuManagerService {

    /**
     * 根据用户Id 获取菜单信息
     * @param adminId
     * @return
     */
    List<UmsMenu> getUmsMenuByAdminId(Long adminId);

    /**
     * 创建后台菜单
     */
    boolean create(UmsMenu umsMenu);

    /**
     * 修改后台菜单
     */
    boolean update(Long id, UmsMenu umsMenu);

    /**
     * 根据ID获取菜单详情
     */
    UmsMenu getItem(Long id);

    /**
     * 根据ID删除菜单
     */
    boolean delete(Long id);

    /**
     * 分页查询后台菜单
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     */
    List<UmsMenuNode> treeList();

    /**
     * 修改菜单显示状态
     */
    boolean updateHidden(Long id, Integer hidden);
}
