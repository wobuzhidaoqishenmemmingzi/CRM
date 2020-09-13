package com.crm.cust.comm.helper;

import com.crm.cust.dto.UmsPermissionNode;
import com.crm.cust.entity.UmsPermission;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UmsPermissionHelper
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/13、1:33
 * @Version 1.0.0
 */
@Component
public class UmsPermissionHelper {

    /**
     * 将权限转换为带有子级的权限对象
     * 当找不到子级权限的时候map操作不会再递归调用covert
     */
    public UmsPermissionNode covert(UmsPermission permission, List<UmsPermission> permissionList){
        UmsPermissionNode node = new UmsPermissionNode();
        BeanUtils.copyProperties(permission,node);
        List<UmsPermissionNode> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(permission.getId()))
                .map(subPermission -> covert(subPermission,permissionList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
