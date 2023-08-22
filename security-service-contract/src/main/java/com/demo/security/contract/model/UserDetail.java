package com.demo.security.contract.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Title: SysUser
 * @Author Hannibal
 * @Package com.demo.security.contract.model
 * @Date 22/08/2023 20:28
 * @Description: 系统用户
 */
public class UserDetail implements UserDetails {
    private UserEntity userEntity;
    private UserRoleRelationEntity userRoleRelationEntity;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
