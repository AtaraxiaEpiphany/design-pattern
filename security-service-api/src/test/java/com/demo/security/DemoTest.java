package com.demo.security;

import com.demo.security.contract.model.RoleEntity;
import com.demo.security.contract.model.UserEntity;
import com.demo.security.contract.model.UserRoleRelationEntity;
import com.demo.security.core.mapper.RoleMapper;
import com.demo.security.core.mapper.UserMapper;
import com.demo.security.core.mapper.UserRoleRelationMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: DemoTest
 * @Author Hannibal
 * @Package com.demo.security
 * @Date 22/08/2023 21:19
 * @Description: TODO
 */
@SpringBootTest
public class DemoTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;

    @Test
    void testUser() {
        List<UserEntity> userEntities = userMapper.selectList(null);
        show(userEntities);
    }

    @Test
    void testRole() {
        List<RoleEntity> roleEntities = roleMapper.selectList(null);
        show(roleEntities);
    }

    @Test
    void testUserRoleRelation() {
        List<UserRoleRelationEntity> userRoleRelationEntities = userRoleRelationMapper.selectList(null);
        show(userRoleRelationEntities);
    }

    private <T> void show(List<T> list) {
        list.forEach(FG_YELLOW::print);
    }
}
