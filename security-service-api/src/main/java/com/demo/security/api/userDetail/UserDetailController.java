package com.demo.security.api.userDetail;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Title: UserDetailController
 * @Author Hannibal
 * @Package com.demo.security.api.controller
 * @Date 22/08/2023 22:08
 * @Description: TODO
 */
@RestController
@Tag(name = "系统用户详情", description = "查看用户详情信息")
@RequestMapping("user-detail")
public class UserDetailController {

    @GetMapping("authentication")
    @Operation(summary = "查看登录用户信息", description = "查看已登录用户详细信息")
    public Authentication getUserDetailByAuthentication(Authentication authentication) {
        return authentication;
    }

    @GetMapping("principal")
    @Operation(summary = "查看登录用户信息", description = "查看已登录用户详细信息")
    public Principal getUserDetailByPrincipal(Principal principal) {
        return principal;
    }

    @GetMapping("context")
    @Operation(summary = "查看登录用户信息", description = "查看已登录用户详细信息")
    public Principal getUserDetailBySecurityContext() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


}
