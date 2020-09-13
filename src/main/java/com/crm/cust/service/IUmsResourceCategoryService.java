package com.crm.cust.service;

import com.crm.cust.entity.UmsResourceCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 资源分类表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsResourceCategoryService extends IService<UmsResourceCategory> {

    /**
     * 获取所有的资源分类信息
     * @return
     */
    List<UmsResourceCategory> getAll();
}
