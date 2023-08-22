package com.demo.security.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.security.contract.model.UserDetail;
import com.demo.security.contract.model.UserEntity;
import com.demo.security.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Title: UserDetailService
 * @Author Hannibal
 * @Package com.demo.security.core.config
 * @Date 22/08/2023 21:52
 * @Description: 自定义系统用户查询服务
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(UserEntity::getUsername, username);
        // 根据用户名查询用户
        UserEntity user = userService.getOne(lqw);
        if (Objects.isNull(user)) {
            return null;
        }
        return new UserDetail(user);
    }
}
