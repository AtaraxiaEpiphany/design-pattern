package com.demo.security.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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
@EnableMethodSecurity
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
        http.formLogin()
                .successHandler((request, response, authentication) -> {
                    response.sendRedirect("/doc.html");
                })
                .permitAll();
//        http.formLogin().permitAll();
//                .successHandler(successHandler());    // 登录成功处理
//                .successForwardUrl("/doc.html");    //登录成功URL
//                .failureForwardUrl()  //登录失败

//        http.logout()
//                .logoutSuccessHandler()

//        http.exceptionHandling()
//                .accessDeniedHandler()  //访问拒绝处理器
//                .accessDeniedPage()  //访问拒绝页面

        /**
         * you have to disable csrf Protection
         * because it is enabled by default in spring security:
         * here you can see code that allow cors origin.
         */
        http.cors().and().csrf().disable();

        return http.build();
    }


}

