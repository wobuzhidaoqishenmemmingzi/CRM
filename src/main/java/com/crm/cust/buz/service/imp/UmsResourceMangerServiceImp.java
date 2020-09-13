package com.crm.cust.buz.service.imp;

import com.crm.cust.buz.service.IUmsResourceMangerService;
import com.crm.cust.entity.UmsResource;
import com.crm.cust.service.IUmsResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UmsResourceMangerServiceImp
 * @Description TODO
 * @Author lvhd
 * @Date 2020/9/13、1:17
 * @Version 1.0.0
 */
@Service
public class UmsResourceMangerServiceImp implements IUmsResourceMangerService {
    private final static Logger logger = LoggerFactory.getLogger(UmsResourceMangerServiceImp.class);

    @Autowired
    private IUmsResourceService umsResourceService;

    @Override
    public boolean create(UmsResource umsResource) {
        umsResource.setCreateTime(new Date());
        return umsResourceService.save(umsResource);
    }

    @Override
    public boolean update(Long id, UmsResource umsResource) {
        umsResource.setId(id);
        return umsResourceService.updateById(umsResource);
    }

    @Override
    public UmsResource getItem(Long id) {
        return umsResourceService.getById(id);
    }

    @Override
    public boolean delete(Long id) {
        return umsResourceService.removeById(id);
    }

    @Override
    public List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        return umsResourceService.getUmsResourceByCategoryIdAndNameKeywordAndUrlKeywordPage(categoryId, nameKeyword, urlKeyword, pageSize, pageNum);
    }

    @Override
    public List<UmsResource> listAll() {
        return umsResourceService.listAll();
    }
}
