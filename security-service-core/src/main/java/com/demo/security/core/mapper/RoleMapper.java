package com.demo.security.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.security.contract.model.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: SysRoleMapper ${MEANING}
 * @Author Hannibal
 * @Package com.demo.security.core.mapper
 * @Date 22/08/2023 21:12
 * @Description: TODO ${description}
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {
    int deleteByPrimaryKey(String roleId);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
}