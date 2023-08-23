package com.demo.security.contract.common;

import com.demo.security.contract.model.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static com.demo.security.contract.constant.AccountEnum.*;

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
        return ACCOUNT_NON_EXPIRED.getCode().equals(userEntity.getAccountNoExpired());
    }

    @Override
    public boolean isAccountNonLocked() {
        return ACCOUNT_NON_LOCKED.getCode().equals(userEntity.getAccountNoLocked());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return CREDENTIALS_NON_EXPIRED.getCode().equals(userEntity.getCredentialsNoExpired());
    }

    @Override
    public boolean isEnabled() {
        return ENABLED.getCode().equals(userEntity.getEnabled());
    }
}
