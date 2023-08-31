package com.demo.security.api.user;

import cn.hutool.core.util.IdUtil;
import com.common.constant.HttpEnum;
import com.common.model.response.HttpResponse;
import com.demo.security.contract.model.UserEntity;
import com.demo.security.contract.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.security.contract.constant.AccountEnum.*;

/**
 * @Title: UserController
 * @Author Hannibal
 * @Package com.demo.security.api.user
 * @Date 23/08/2023 21:53
 * @Description: TODO
 */
@RestController
@RequestMapping("user")
@Tag(name = "用户接口", description = "")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAnyAuthority('add')")
    @PostMapping("insert")
    @Operation(summary = "添加系统用户", description = "新增系统用户")
    public HttpResponse addUser(@RequestBody UserEntity user) {
        user.setUserId(String.valueOf(IdUtil.getSnowflakeNextId()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAccountNoExpired(ACCOUNT_NON_EXPIRED.getCode());
        user.setCredentialsNoExpired(CREDENTIALS_NON_EXPIRED.getCode());
        user.setAccountNoLocked(ACCOUNT_NON_LOCKED.getCode());
        user.setEnabled(ENABLED.getCode());
        boolean save = userService.save(user);
        return new HttpResponse.builder()
                .data(save)
                .responsable(HttpEnum.OK)
                .build();
    }
}
