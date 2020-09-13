package com.crm.cust.service.imp;

import com.crm.cust.dao.UmsResourceCategoryMapper;
import com.crm.cust.entity.UmsResourceCategory;
import com.crm.cust.service.IUmsResourceCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 资源分类表 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryMapper, UmsResourceCategory> implements IUmsResourceCategoryService {

    @Override
    public List<UmsResourceCategory> getAll() {
        return this.list();
    }
}
