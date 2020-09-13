package com.crm.cust.service.imp;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm.cust.dao.UmsResourceMapper;
import com.crm.cust.entity.UmsResource;
import com.crm.cust.service.IUmsResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource> implements IUmsResourceService {

    @Override
    public List<UmsResource> listAll() {
        return this.list();
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        return getBaseMapper().getResourceList(adminId);
    }

    @Override
    public List<UmsResource> getUmsResourceByCategoryIdAndNameKeywordAndUrlKeywordPage(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<UmsResource> queryWrapper = new QueryWrapper<UmsResource>();
        queryWrapper.eq(categoryId != null, "CATEGORY_ID", categoryId);
        queryWrapper.like(StrUtil.isNotEmpty(nameKeyword), "NAME", nameKeyword);
        queryWrapper.like(StrUtil.isNotBlank(urlKeyword), "URL", urlKeyword);
        return this.list(queryWrapper);
    }

    @Override
    public List<UmsResource> getUmsResourceByRoleId(Long roleId) {
        return this.getBaseMapper().getUmsResourceByRoleId(roleId);
    }

}
