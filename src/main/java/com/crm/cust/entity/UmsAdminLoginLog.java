package com.crm.cust.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台用户登录日志表
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmsAdminLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("ADMIN_ID")
    private Long adminId;

    @TableField("CREATE_TIME")
    private Date createTime;

    @TableField("IP")
    private String ip;

    @TableField("ADDRESS")
    private String address;

    /**
     * 浏览器登录类型
     */
    @TableField("USER_AGENT")
    private String userAgent;


}
