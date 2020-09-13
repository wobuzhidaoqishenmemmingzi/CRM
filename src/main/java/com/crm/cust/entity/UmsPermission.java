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
 * 后台用户权限表
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmsPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 父级权限id
     */
    @TableField("PID")
    private Long pid;

    /**
     * 名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 权限值
     */
    @TableField("VALUE")
    private String value;

    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    @TableField("TYPE")
    private Integer type;

    /**
     * 前端资源路径
     */
    @TableField("URI")
    private String uri;

    /**
     * 启用状态；0->禁用；1->启用
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 排序
     */
    @TableField("SORT")
    private Integer sort;


}
