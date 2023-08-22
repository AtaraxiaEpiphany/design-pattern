package com.demo.security.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.security.contract.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: SysUserMapper ${MEANING}
 * @Author Hannibal
 * @Package com.demo.security.core.mapper
 * @Date 22/08/2023 21:12
 * @Description: TODO ${description}
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    int deleteByPrimaryKey(String userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}