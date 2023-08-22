package com.demo.security.contract.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @Title: SysRole ${MEANING}
 * @Author Hannibal
 * @Package com.demo.security.contract.model
 * @Date 22/08/2023 21:12
 * @Description: TODO ${description}
 */
@TableName("sys_role")
@Schema
@Data
public class RoleEntity implements Serializable {
    /**
     * 主键
     */
    @Schema(description = "主键")
    @TableId
    private String roleId;

    /**
     * 权限名称
     */
    @Schema(description = "权限名称")
    private String roleName;

    /**
     * 权限说明
     */
    @Schema(description = "权限说明")
    private String roleDescription;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}