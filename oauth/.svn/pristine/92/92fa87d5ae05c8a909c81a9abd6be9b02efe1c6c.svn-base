package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.ChannelPermissionDO;
import com.ybinsure.auth.model.data.ChannelPermissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChannelPermissionDOMapper {
    long countByExample(ChannelPermissionDOExample example);

    int deleteByExample(ChannelPermissionDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ChannelPermissionDO record);

    int insertSelective(ChannelPermissionDO record);

    List<ChannelPermissionDO> selectByExample(ChannelPermissionDOExample example);

    ChannelPermissionDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ChannelPermissionDO record, @Param("example") ChannelPermissionDOExample example);

    int updateByExample(@Param("record") ChannelPermissionDO record, @Param("example") ChannelPermissionDOExample example);

    int updateByPrimaryKeySelective(ChannelPermissionDO record);

    int updateByPrimaryKey(ChannelPermissionDO record);
}