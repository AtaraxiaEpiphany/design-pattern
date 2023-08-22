package com.demo.security.contract.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @Title: SysUser ${MEANING}
 * @Author Hannibal
 * @Package com.demo.security.contract.model
 * @Date 22/08/2023 21:12
 * @Description: TODO ${description}
 */
@TableName("sys_user")
@Schema
@Data
public class UserEntity implements Serializable {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private String userId;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;

    /**
     * 用户密码
     */
    @Schema(description = "用户密码")
    private String password;

    /**
     * 是否启用账号
     */
    @Schema(description = "是否启用账号")
    private String enabled;

    /**
     * 账号是否过期
     */
    @Schema(description = "账号是否过期")
    private String accountNoExpired;

    /**
     * 账号是否锁定
     */
    @Schema(description = "账号是否锁定")
    private String accountNoLocked;

    /**
     * 凭证是否过期
     */
    @Schema(description = "凭证是否过期")
    private String credentialsNoExpired;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}