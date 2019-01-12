package com.ybinsure.auth.mapper.data;

import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.PermissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PermissionDOMapper {
    long countByExample(PermissionDOExample example);

    int deleteByExample(PermissionDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(PermissionDO record);

    int insertSelective(PermissionDO record);

    List<PermissionDO> selectByExample(PermissionDOExample example);

    PermissionDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PermissionDO record, @Param("example") PermissionDOExample example);

    int updateByExample(@Param("record") PermissionDO record, @Param("example") PermissionDOExample example);

    int updateByPrimaryKeySelective(PermissionDO record);

    int updateByPrimaryKey(PermissionDO record);
}