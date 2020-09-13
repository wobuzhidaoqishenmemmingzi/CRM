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
 * 后台菜单表
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmsMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 父级ID
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 菜单名称
     */
    @TableField("TITLE")
    private String title;

    /**
     * 菜单级数
     */
    @TableField("LEVEL")
    private Integer level;

    /**
     * 菜单排序
     */
    @TableField("SORT")
    private Integer sort;

    /**
     * 前端名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 前端图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 前端隐藏
     */
    @TableField("HIDDEN")
    private Integer hidden;


}
