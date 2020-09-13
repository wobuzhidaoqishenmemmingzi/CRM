package com.crm.cust.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * 修改用户名密码参数
 */
@Getter
@Setter
public class UpdateAdminPasswordParam {
    /**
     * 用户名
     */
    @NotEmpty
    private String username;
    /**
     * 旧密码
     */
    @NotEmpty
    private String oldPassword;
    /**
     * 新密码
     */
    @NotEmpty
    private String newPassword;
}
