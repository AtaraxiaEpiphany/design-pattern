package com.demo.security.contract.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Title: SysUserRoleRelation ${MEANING}
 * @Author Hannibal
 * @Package com.demo.security.contract.model
 * @Date 22/08/2023 21:12
 * @Description: TODO ${description}
 */
@TableName("sys_user_role_relation")
@Schema
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleRelationEntity implements Serializable {
    /**
     * 主键
     */
    @Schema(description = "主键")
    @TableId
    private String userRoleRelationId;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private String userId;

    /**
     * 权限id
     */
    @Schema(description = "权限id")
    private String roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}