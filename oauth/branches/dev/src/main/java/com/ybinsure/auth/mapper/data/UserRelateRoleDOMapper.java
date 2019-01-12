package com.ybinsure.auth.mapper.data;

import com.ybinsure.auth.model.data.UserRelateRoleDO;
import com.ybinsure.auth.model.data.UserRelateRoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRelateRoleDOMapper {
    long countByExample(UserRelateRoleDOExample example);

    int deleteByExample(UserRelateRoleDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserRelateRoleDO record);

    int insertSelective(UserRelateRoleDO record);

    List<UserRelateRoleDO> selectByExample(UserRelateRoleDOExample example);

    UserRelateRoleDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserRelateRoleDO record, @Param("example") UserRelateRoleDOExample example);

    int updateByExample(@Param("record") UserRelateRoleDO record, @Param("example") UserRelateRoleDOExample example);

    int updateByPrimaryKeySelective(UserRelateRoleDO record);

    int updateByPrimaryKey(UserRelateRoleDO record);
}