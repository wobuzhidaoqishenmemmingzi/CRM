package com.crm.cust.comm.helper;

import com.crm.cust.dto.UmsMenuNode;
import com.crm.cust.entity.UmsMenu;
import com.crm.cust.service.IUmsMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UmsMenuHelper
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/13、0:50
 * @Version 1.0.0
 */
@Component
public class UmsMenuHelper {

    @Autowired
    private IUmsMenuService umsMenuService;
    /**
     * 修改菜单层级
     */
    public void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            UmsMenu parentMenu = umsMenuService.getById(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
    }

    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     */
    public UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
