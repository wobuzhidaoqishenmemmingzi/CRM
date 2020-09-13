package com.crm.cust.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.cust.dao.UmsMenuMapper;
import com.crm.cust.entity.UmsMenu;
import com.crm.cust.service.IUmsMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuMapper, UmsMenu> implements IUmsMenuService {

    @Override
    public List<UmsMenu> getUmsMenuByAdminId(Long adminId) {
        return this.getBaseMapper().getUmsMenuByAdminId(adminId);
    }

    @Override
    public List<UmsMenu> getAll() {
        return this.list();
    }

    @Override
    public List<UmsMenu> getUmsMenuByParentIdPage(Long parentId, Integer pageSize, Integer pageNum) {
        Page<UmsMenu> page =  PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<UmsMenu> queryWrapper = new QueryWrapper<UmsMenu>();
        queryWrapper.eq("PARENT_ID", parentId);
        return this.list(queryWrapper);
    }

    @Override
    public List<UmsMenu> getUmsMenuByRoleId(Long roleId) {
        return this.getBaseMapper().getUmsMenuByRoleId(roleId);
    }
}
