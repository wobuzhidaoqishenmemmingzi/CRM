package com.crm.cust.buz.service.imp;

import com.crm.cust.buz.service.IUmsMenuManagerService;
import com.crm.cust.comm.helper.UmsMenuHelper;
import com.crm.cust.dto.UmsMenuNode;
import com.crm.cust.entity.UmsMenu;
import com.crm.cust.service.IUmsMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UmsMenuManagerServiceImp
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/13、0:36
 * @Version 1.0.0
 */
@Service
public class UmsMenuManagerServiceImp implements IUmsMenuManagerService {

    private final static Logger logger = LoggerFactory.getLogger(UmsMenuManagerServiceImp.class);
    @Autowired
    private IUmsMenuService umsMenuService;
    @Autowired
    private UmsMenuHelper umsMenuHelper;
    @Override
    public List<UmsMenu> getUmsMenuByAdminId(Long adminId) {
        return umsMenuService.getUmsMenuByAdminId(adminId);
    }

    @Override
    public boolean create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        umsMenuHelper.updateLevel(umsMenu);
        return umsMenuService.save(umsMenu);
    }

    @Override
    public boolean update(Long id, UmsMenu umsMenu) {
        umsMenu.setId(id);
        umsMenuHelper.updateLevel(umsMenu);
        return umsMenuService.updateById(umsMenu);
    }

    @Override
    public UmsMenu getItem(Long id) {
        return umsMenuService.getById(id);
    }

    @Override
    public boolean delete(Long id) {
        return umsMenuService.removeById(id);
    }

    @Override
    public List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        return umsMenuService.getUmsMenuByParentIdPage(parentId, pageSize, pageNum);
    }

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList = umsMenuService.getAll();
        List<UmsMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> umsMenuHelper.covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public boolean updateHidden(Long id, Integer hidden) {
        UmsMenu umsMenu = new UmsMenu();
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        return umsMenuService.updateById(umsMenu);
    }
}
