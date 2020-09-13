package com.crm.cust.buz.service;

import com.crm.cust.entity.UmsMenu;
import com.crm.cust.entity.UmsPermission;
import com.crm.cust.entity.UmsResource;
import com.crm.cust.entity.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUmsRoleManagerService {

    /**
     * 添加角色
     */
    boolean create(UmsRole role);

    /**
     * 修改角色信息
     */
    boolean update(Long id, UmsRole role);

    /**
     * 批量删除角色
     */
    boolean delete(List<Long> ids);

    /**
     * 获取指定角色权限
     */
    List<UmsPermission> getPermissionList(Long roleId);

    /**
     * 修改指定角色的权限
     */
    @Transactional(rollbackFor = Exception.class)
    boolean updatePermission(Long roleId, List<Long> permissionIds);

    /**
     * 获取所有角色列表
     */
    List<UmsRole> list();

    /**
     * 分页获取角色列表
     */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * 获取角色相关菜单
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     */
    @Transactional(rollbackFor = Exception.class)
    boolean allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional(rollbackFor = Exception.class)
    boolean allocResource(Long roleId, List<Long> resourceIds);
}
