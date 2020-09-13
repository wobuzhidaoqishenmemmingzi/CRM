package com.crm.cust.service;

import com.crm.cust.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
public interface IUmsAdminService extends IService<UmsAdmin> {

    /**
     * 获取用户信息
     */
    UmsAdmin loadUserByUsername(String username);

    /**
     * 根据用户名获取所有用户
     * @param userName
     * @return
     */
    List<UmsAdmin> getUmsAdminByUserName(String userName);

    /**
     * 根据用户名模糊查询用户信息分页
     * @param userName
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsAdmin> getListLikeUserNamePage(String userName, Integer pageSize, Integer pageNum);
}
