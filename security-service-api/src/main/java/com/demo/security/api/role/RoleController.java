package com.demo.security.api.role;

import cn.hutool.core.util.IdUtil;
import com.demo.security.contract.model.RoleEntity;
import com.demo.security.contract.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: RoleController
 * @Author Hannibal
 * @Package com.demo.security.api.role
 * @Date 23/08/2023 21:53
 * @Description: TODO
 */
@RestController
@RequestMapping("role")
@Tag(name = "权限接口", description = "")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    @Operation(summary = "", description = "")
    public Boolean addRole(@RequestBody RoleEntity role) {
        role.setRoleId(String.valueOf(IdUtil.getSnowflakeNextId()));
        return roleService.save(role);
    }
}
