package com.demo.security.contract.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.security.contract.model.RoleEntity;

/**
 * @Title: SysRoleService
 * @Author Hannibal
 * @Package com.demo.security.contract.service
 * @Date 22/08/2023 21:35
 * @Description: TODO
 */
public interface RoleService extends IService<RoleEntity> {
    RoleEntity getRoleByRoleName(String roleName);
}
