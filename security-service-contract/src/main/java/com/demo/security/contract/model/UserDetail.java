package com.demo.security.contract.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Title: SysUser
 * @Author Hannibal
 * @Package com.demo.security.contract.model
 * @Date 22/08/2023 20:28
 * @Description: 系统用户
 */
@Data
@NoArgsConstructor
public class UserDetail implements UserDetails {

    private UserEntity userEntity;

    private List<GrantedAuthority> authorityList;

    public UserDetail(UserEntity userEntity) {
        this.userEntity = userEntity;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        String password = userEntity.getPassword();
        userEntity.setPassword(null);
        return password;
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
