package com.luochen.financial.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@ApiModel
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录id
     */
    @ApiModelProperty("登录id")
    @TableField("login_id")
    private String loginId;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    /**
     * 别名
     */
    @ApiModelProperty("别名")
    @TableField("name")
    private String name;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    /**
     * 简介
     */
    @ApiModelProperty("简介")
    @TableField("introduction")
    private String introduction;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty()
    @TableField("access_key")
    private String accessKey;

    @ApiModelProperty()
    @TableField("secret_key")
    private String secretKey;

    @ApiModelProperty("状态")
    @TableField("status")
    private Integer status;


}
