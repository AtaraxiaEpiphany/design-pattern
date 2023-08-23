package com.demo.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.security.contract.model.UserEntity;
import com.demo.security.contract.service.UserService;
import com.demo.security.core.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Title: SysUserServiceImpl
 * @Author Hannibal
 * @Package com.demo.security.core.service.impl
 * @Date 22/08/2023 21:37
 * @Description: TODO
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
}
