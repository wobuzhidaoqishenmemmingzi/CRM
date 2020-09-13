package com.crm.cust.service;

import com.crm.cust.entity.UmsResource;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsResourceService extends IService<UmsResource> {

    /**
     * 获取所有资源信息
     * @return
     */
    List<UmsResource> listAll();
    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 根据 条件 获取 后台资源 信息
     * @param categoryId 资源分类ID
     * @param nameKeyword 资源名称
     * @param urlKeyword 资源URL
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsResource> getUmsResourceByCategoryIdAndNameKeywordAndUrlKeywordPage(Long categoryId,
                                                                                String nameKeyword,
                                                                                String urlKeyword,
                                                                                Integer pageSize, Integer pageNum);

    /**
     * 根据 角色id 查询 用户所有可访问资源
     * @param roleId
     * @return
     */
    List<UmsResource> getUmsResourceByRoleId(Long roleId);

}
