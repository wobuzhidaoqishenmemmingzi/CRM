package com.crm.cust.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsAdminLoginParam {

    /**
     * 用户名
     */
    @NotEmpty
    private String username;

    /**
    * 密码
    */
    @NotEmpty
    private String password;
}
