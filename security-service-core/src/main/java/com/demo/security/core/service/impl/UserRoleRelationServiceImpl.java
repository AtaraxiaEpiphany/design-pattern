package com.demo.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.security.contract.model.UserRoleRelationEntity;
import com.demo.security.contract.service.UserRoleRelationService;
import com.demo.security.core.mapper.UserRoleRelationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Title: SysUserRoleRelationServiceImpl
 * @Author Hannibal
 * @Package com.demo.security.core.service.impl
 * @Date 22/08/2023 21:38
 * @Description: TODO
 */
@Service
@Slf4j
public class UserRoleRelationServiceImpl extends ServiceImpl<UserRoleRelationMapper, UserRoleRelationEntity> implements UserRoleRelationService {
}
