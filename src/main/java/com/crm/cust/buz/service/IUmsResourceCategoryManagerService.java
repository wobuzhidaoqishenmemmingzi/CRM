package com.crm.cust.buz.service;

import com.crm.cust.entity.UmsResourceCategory;

import java.util.List;

public interface IUmsResourceCategoryManagerService {

    /**
     * 获取所有资源分类
     */
    List<UmsResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    boolean create(UmsResourceCategory umsResourceCategory);

    /**
     * 修改资源分类
     */
    boolean update(Long id, UmsResourceCategory umsResourceCategory);

    /**
     * 删除资源分类
     */
    boolean delete(Long id);
}
