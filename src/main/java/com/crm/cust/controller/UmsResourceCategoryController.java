package com.crm.cust.controller;

import com.crm.cust.buz.service.IUmsResourceCategoryManagerService;
import com.crm.cust.comm.api.CommonResult;
import com.crm.cust.entity.UmsResourceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源分类管理Controller
 */
@Controller
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private IUmsResourceCategoryManagerService resourceCategoryService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResourceCategory>> listAll() {
        List<UmsResourceCategory> resourceList = resourceCategoryService.listAll();
        return CommonResult.success(resourceList);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsResourceCategory umsResourceCategory) {
        boolean flag = resourceCategoryService.create(umsResourceCategory);
        if (flag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody UmsResourceCategory umsResourceCategory) {
        boolean flag = resourceCategoryService.update(id, umsResourceCategory);
        if (flag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        boolean flag = resourceCategoryService.delete(id);
        if (flag) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }
}
