package com.demo.security.core.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.security.contract.model.RoleEntity;
import com.demo.security.contract.model.UserEntity;
import com.demo.security.contract.model.UserRoleRelationEntity;
import com.demo.security.contract.service.RoleService;
import com.demo.security.contract.service.UserRoleRelationService;
import com.demo.security.contract.service.UserService;
import com.demo.security.core.mapper.UserRoleRelationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @Override
    public List<String> getRoleByUserId(String userId) {
        LambdaQueryWrapper<UserRoleRelationEntity> lwq = new LambdaQueryWrapper<>();
        lwq.eq(UserRoleRelationEntity::getUserId, userId);
        List<UserRoleRelationEntity> list = list(lwq);
        List<String> roleIds = list.stream()
                .map(UserRoleRelationEntity::getRoleId)
                .toList();
        LambdaQueryWrapper<RoleEntity> qw = new LambdaQueryWrapper<>();
        if (roleIds.isEmpty()) {
            return new ArrayList<>();
        }
        qw.in(RoleEntity::getRoleId, roleIds);
        List<RoleEntity> roles = roleService.list(qw);
        return roles.stream()
                .map(RoleEntity::getRoleName)
                .distinct().collect(Collectors.toList());
    }

    @Override
    public boolean addRole(String username, String roleName) {
        UserEntity user = userService.getUserByUserName(username);
        RoleEntity role = roleService.getRoleByRoleName(roleName);
        if (Objects.isNull(user) || Objects.isNull(role)) {
            return false;
        }
        UserRoleRelationEntity entity = new UserRoleRelationEntity(IdUtil.fastUUID(), user.getUserId(), role.getRoleId());
        return save(entity);
    }

}
