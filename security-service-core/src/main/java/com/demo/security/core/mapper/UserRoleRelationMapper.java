package com.demo.security.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.security.contract.model.UserRoleRelationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: SysUserRoleRelationMapper ${MEANING}
 * @Author Hannibal
 * @Package com.demo.security.core.mapper
 * @Date 22/08/2023 21:12
 * @Description: TODO ${description}
 */
@Mapper
public interface UserRoleRelationMapper extends BaseMapper<UserRoleRelationEntity> {
    int deleteByPrimaryKey(String userRoleRelationId);

    int insert(UserRoleRelationEntity record);

    int insertSelective(UserRoleRelationEntity record);

    UserRoleRelationEntity selectByPrimaryKey(String userRoleRelationId);

    int updateByPrimaryKeySelective(UserRoleRelationEntity record);

    int updateByPrimaryKey(UserRoleRelationEntity record);
}