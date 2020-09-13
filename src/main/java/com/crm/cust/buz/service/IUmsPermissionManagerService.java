package com.crm.cust.buz.service;

import com.crm.cust.dto.UmsPermissionNode;
import com.crm.cust.entity.UmsPermission;

import java.util.List;

public interface IUmsPermissionManagerService {

    /**
     * 添加权限
     */
    boolean create(UmsPermission permission);

    /**
     * 修改权限
     */
    boolean update(Long id,UmsPermission permission);

    /**
     * 批量删除权限
     */
    boolean delete(List<Long> ids);

    /**
     * 以层级结构返回所有权限
     */
    List<UmsPermissionNode> treeList();

    /**
     * 获取所有权限
     */
    List<UmsPermission> list();
}
