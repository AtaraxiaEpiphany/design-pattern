package com.demo.security.api.userRoleRelation;

import com.demo.security.contract.common.ResponseResult;
import com.demo.security.contract.service.UserRoleRelationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: UserRoleController
 * @Author Hannibal
 * @Package com.demo.security.api.userRoleRelation
 * @Date 23/08/2023 21:53
 * @Description: TODO
 */
@RestController
@RequestMapping("user-role")
@Tag(name = "用户权限接口", description = "")
public class UserRoleController {
    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @PostMapping
    @Operation(summary = "给用户赋权", description = "")
    public Boolean addRole2user(String username, String roleName) {
        return userRoleRelationService.addRole(username, roleName);
    }

    @Operation(summary = "查看用户权限", description = "")
    @GetMapping
    public ResponseResult getRoles(String userId) {
        List<String> roles = userRoleRelationService.getRoleByUserId(userId);
        return ResponseResult.ok(roles);
    }
}
