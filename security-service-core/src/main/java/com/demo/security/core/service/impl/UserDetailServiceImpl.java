package com.demo.security.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.security.contract.common.UserDetail;
import com.demo.security.contract.model.UserEntity;
import com.demo.security.contract.service.UserRoleRelationService;
import com.demo.security.contract.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Title: UserDetailService
 * @Author Hannibal
 * @Package com.demo.security.core.config
 * @Date 22/08/2023 21:52
 * @Description: 自定义系统用户查询服务
 */
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(UserEntity::getUsername, username);
        // 根据用户名查询用户
        UserEntity user = userService.getOne(lqw);
        if (Objects.isNull(user)) {
            return null;
        }
        UserDetail userDetail = new UserDetail(user);
        List<String> roles = userRoleRelationService.getRoleByUserId(user.getUserId());
        if (!roles.isEmpty()) {
            List<GrantedAuthority> collect = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            userDetail.setAuthorityList(collect);
        }
        return userDetail;
    }

}
