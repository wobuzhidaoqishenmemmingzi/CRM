package com.crm.cust.dto;


import com.crm.cust.entity.UmsMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    /**
     * 子级菜单
     */
    private List<UmsMenuNode> children;
}
