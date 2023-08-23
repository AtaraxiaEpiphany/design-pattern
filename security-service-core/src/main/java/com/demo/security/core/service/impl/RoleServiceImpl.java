package com.demo.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.security.contract.model.RoleEntity;
import com.demo.security.contract.service.RoleService;
import com.demo.security.core.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Title: SysRoleServiceImpl
 * @Author Hannibal
 * @Package com.demo.security.core.service.impl
 * @Date 22/08/2023 21:37
 * @Description: TODO
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {
}
