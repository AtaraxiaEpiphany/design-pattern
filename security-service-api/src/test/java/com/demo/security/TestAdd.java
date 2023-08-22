package com.demo.security;

import com.demo.security.contract.model.UserEntity;
import com.demo.security.contract.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private PasswordEncoder passwordEncoder;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(6);

    @Test
    void testAddUser() {
        for (int i = 1; i <= 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(UUID.randomUUID().toString());
            userEntity.setUsername(String.valueOf(i));
            userEntity.setPassword(passwordEncoder.encode(String.valueOf(i)));
            userEntity.setAccountNoExpired(String.valueOf(i));
            userEntity.setCredentialsNoExpired(String.valueOf(i));
            userEntity.setAccountNoLocked(String.valueOf(i));
            userEntity.setEnabled(String.valueOf(i));
            userService.save(userEntity);
        }
    }
}
