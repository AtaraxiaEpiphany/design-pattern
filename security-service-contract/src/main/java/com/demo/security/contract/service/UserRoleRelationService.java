package com.demo.security.contract.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.security.contract.model.UserRoleRelationEntity;

import java.util.List;

/**
 * @Title: SysUserRoleRelationService
 * @Author Hannibal
 * @Package com.demo.security.contract.service
 * @Date 22/08/2023 21:35
 * @Description: TODO
 */
public interface UserRoleRelationService extends IService<UserRoleRelationEntity> {
    List<String> getRoleByUserId(String userId);

    boolean addRole(String username, String roleName);
}
