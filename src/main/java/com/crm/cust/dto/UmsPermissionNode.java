package com.crm.cust.dto;

import com.crm.cust.entity.UmsPermission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台权限节点封装
 */
public class UmsPermissionNode extends UmsPermission {
    @Getter
    @Setter
    /**
     *子级权限
     */
    private List<UmsPermissionNode> children;
}
