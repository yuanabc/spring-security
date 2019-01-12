package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.ChannelDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChannelDOMapper {
    long countByExample(ChannelDOExample example);

    int deleteByExample(ChannelDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ChannelDO record);

    int insertSelective(ChannelDO record);

    List<ChannelDO> selectByExample(ChannelDOExample example);

    ChannelDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ChannelDO record, @Param("example") ChannelDOExample example);

    int updateByExample(@Param("record") ChannelDO record, @Param("example") ChannelDOExample example);

    int updateByPrimaryKeySelective(ChannelDO record);

    int updateByPrimaryKey(ChannelDO record);
}