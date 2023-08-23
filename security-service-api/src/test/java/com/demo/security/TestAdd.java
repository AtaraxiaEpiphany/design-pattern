package com.demo.security;

import cn.hutool.core.util.IdUtil;
import com.demo.security.contract.model.RoleEntity;
import com.demo.security.contract.model.UserEntity;
import com.demo.security.contract.service.RoleService;
import com.demo.security.contract.service.UserRoleRelationService;
import com.demo.security.contract.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.demo.security.contract.constant.AccountEnum.*;

/**
 * @Title: TestAddUser
 * @Author Hannibal
 * @Package com.demo.security
 * @Date 22/08/2023 22:36
 * @Description: TODO
 */
@SpringBootTest
public class TestAdd {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleRelationService userRoleRelationService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(6);

    @Test
    void testAddUser() {
        UserEntity user = new UserEntity();
        user.setUserId(IdUtil.fastUUID());
        user.setUserId(UUID.randomUUID().toString());
        user.setUsername("root");
        user.setPassword(passwordEncoder.encode("9660527"));
        user.setAccountNoExpired(ACCOUNT_NON_EXPIRED.getCode());
        user.setCredentialsNoExpired(CREDENTIALS_NON_EXPIRED.getCode());
        user.setAccountNoLocked(ACCOUNT_NON_LOCKED.getCode());
        user.setEnabled(ENABLED.getCode());
        userService.save(user);
    }

    @Test
    void testAddRole() {
        RoleEntity roleEntity = new RoleEntity(UUID.randomUUID().toString(),
                "admin", "超级管理员权限");
        roleService.save(roleEntity);
    }

    @Test
    void testAddRole2user() {
        userRoleRelationService.addRole("root", "admin");
    }
}
