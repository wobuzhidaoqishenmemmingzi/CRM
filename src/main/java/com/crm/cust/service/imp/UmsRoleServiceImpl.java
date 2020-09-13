package com.crm.cust.service.imp;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.cust.dao.UmsRoleMapper;
import com.crm.cust.entity.UmsRole;
import com.crm.cust.service.IUmsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements IUmsRoleService {

    @Override
    public List<UmsRole> getUmsRoleByAdminId(Long adminId) {
        return getBaseMapper().getUmsRoleByAdminId(adminId);
    }

    @Override
    public List<UmsRole> getUmsRoleByNamePage(String nameKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<UmsRole> queryWrapper = new QueryWrapper<UmsRole>();
        queryWrapper.like(StrUtil.isNotBlank(nameKeyword), "NAME", nameKeyword);
        return this.list(queryWrapper);
    }
}
