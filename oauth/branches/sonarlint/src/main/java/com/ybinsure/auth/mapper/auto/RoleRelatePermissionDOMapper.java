package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.RoleRelatePermissionDO;
import com.ybinsure.auth.model.data.RoleRelatePermissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleRelatePermissionDOMapper {
    long countByExample(RoleRelatePermissionDOExample example);

    int deleteByExample(RoleRelatePermissionDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleRelatePermissionDO record);

    int insertSelective(RoleRelatePermissionDO record);

    List<RoleRelatePermissionDO> selectByExample(RoleRelatePermissionDOExample example);

    RoleRelatePermissionDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleRelatePermissionDO record, @Param("example") RoleRelatePermissionDOExample example);

    int updateByExample(@Param("record") RoleRelatePermissionDO record, @Param("example") RoleRelatePermissionDOExample example);

    int updateByPrimaryKeySelective(RoleRelatePermissionDO record);

    int updateByPrimaryKey(RoleRelatePermissionDO record);
}