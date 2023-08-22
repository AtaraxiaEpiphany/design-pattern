package com.demo.security.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Title: WebSecurityConfig
 * @Author Hannibal
 * @Package com.demo.security.core.service.config
 * @Date 22/08/2023 20:14
 * @Description: TODO
 */
@Configuration
public class WebSecurityConfig {
    /**
     * @return 定义密码加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
