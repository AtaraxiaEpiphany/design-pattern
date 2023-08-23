package com.demo.security.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("doc.html/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
        );
        http.formLogin().permitAll();
//                .successHandler();   登录成功处理
//                .successForwardUrl()  登录成功URL
//                .failureForwardUrl()  登录失败

//        http.logout()
//                .logoutSuccessHandler()

//        http.exceptionHandling()
//                .accessDeniedHandler()  //访问拒绝处理器
//                .accessDeniedPage()  //访问拒绝页面

        return http.build();
    }
}

