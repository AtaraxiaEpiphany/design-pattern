package com.demo.security.api.controller;

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
@RequestMapping("user-detail")
public class UserDetailController {

    @GetMapping("authentication")
    public Authentication getUserDetailByAuthentication(Authentication authentication) {
        return authentication;
    }

    @GetMapping("principal")
    public Principal getUserDetailByPrincipal(Principal principal) {
        return principal;
    }

    @GetMapping("context")
    public Principal getUserDetailBySecurityContext() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
