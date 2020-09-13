package com.crm.cust.buz.service.imp;

import com.crm.cust.buz.service.IUmsPermissionManagerService;
import com.crm.cust.comm.helper.UmsPermissionHelper;
import com.crm.cust.dto.UmsPermissionNode;
import com.crm.cust.entity.UmsPermission;
import com.crm.cust.service.IUmsPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UmsPermissionManagerServiceImp
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/13、1:15
 * @Version 1.0.0
 */
@Service
public class UmsPermissionManagerServiceImp implements IUmsPermissionManagerService {

    private final static Logger logger = LoggerFactory.getLogger(UmsPermissionManagerServiceImp.class);

    @Autowired
    private IUmsPermissionService umsPermissionService;
    @Autowired
    private UmsPermissionHelper umsPermissionHelper;
    @Override
    public boolean create(UmsPermission permission) {
        permission.setStatus(1);
        permission.setCreateTime(new Date());
        permission.setSort(0);
        return umsPermissionService.save(permission);
    }

    @Override
    public boolean update(Long id, UmsPermission permission) {
        permission.setId(id);
        return umsPermissionService.updateById(permission);
    }

    @Override
    public boolean delete(List<Long> ids) {
        return umsPermissionService.removeByIds(ids);
    }

    @Override
    public List<UmsPermissionNode> treeList() {
        List<UmsPermission> permissionList = umsPermissionService.getAll();
        List<UmsPermissionNode> result = permissionList.stream()
                .filter(permission -> permission.getPid().equals(0L))
                .map(permission -> umsPermissionHelper.covert(permission,permissionList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<UmsPermission> list() {
        return umsPermissionService.getAll();
    }
}
