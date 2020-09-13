package com.crm.cust.comm.helper;

import com.crm.cust.entity.UmsAdminPermissionRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UmsAdminPermissionRelationHelper
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/13、0:18
 * @Version 1.0.0
 */
@Component
public class UmsAdminPermissionRelationHelper {

    /**
     * 将+-权限关系转化为对象
     */
    public List<UmsAdminPermissionRelation> convert(Long adminId, Integer type, List<Long> permissionIdList) {
        List<UmsAdminPermissionRelation> relationList = permissionIdList.stream().map(permissionId -> {
            UmsAdminPermissionRelation relation = new UmsAdminPermissionRelation();
            relation.setAdminId(adminId);
            relation.setType(type);
            relation.setPermissionId(permissionId);
            return relation;
        }).collect(Collectors.toList());
        return relationList;
    }
}
