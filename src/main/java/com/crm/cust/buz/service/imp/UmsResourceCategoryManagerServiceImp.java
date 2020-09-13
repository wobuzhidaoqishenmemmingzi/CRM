package com.crm.cust.buz.service.imp;

import cn.hutool.core.collection.CollectionUtil;
import com.crm.cust.buz.service.IUmsResourceCategoryManagerService;
import com.crm.cust.entity.UmsResourceCategory;
import com.crm.cust.service.IUmsResourceCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UmsResourceCategoryManagerServiceImp
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/13、1:16
 * @Version 1.0.0
 */
@Service
public class UmsResourceCategoryManagerServiceImp implements IUmsResourceCategoryManagerService{
    private final static Logger logger = LoggerFactory.getLogger(UmsResourceCategoryManagerServiceImp.class);

    @Autowired
    private IUmsResourceCategoryService umsResourceCategoryService;

    @Override
    public List<UmsResourceCategory> listAll() {
        List<UmsResourceCategory> list = umsResourceCategoryService.getAll();

        CollectionUtil.sort(list, new Comparator<UmsResourceCategory>(){
            @Override
            public int compare(UmsResourceCategory o1, UmsResourceCategory o2) {
                return o1.getSort().compareTo(o2.getSort());
            }
        });
        return list;
    }

    @Override
    public boolean create(UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setCreateTime(new Date());
        return umsResourceCategoryService.save(umsResourceCategory);
    }

    @Override
    public boolean update(Long id, UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setId(id);
        return umsResourceCategoryService.updateById(umsResourceCategory);
    }

    @Override
    public boolean delete(Long id) {
        return umsResourceCategoryService.removeById(id);
    }
}
