package com.crm.cust.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 */
@Getter
@Setter
public class UmsAdminParam {

    /**
     *用户名
     */
    @NotEmpty
    private String username;

    /**
     * 密码
     */
    @NotEmpty
    private String password;
    /**
     * 用户头像
     */
    private String icon;

    /**
     * 邮箱
     */
    @Email
    private String email;
    /**
     * 用户昵称
      */
    private String nickName;
    /**
     * 备注
     */
    private String note;
}
