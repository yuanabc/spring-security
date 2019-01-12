package com.ybinsure.auth.mapper.data;

import com.ybinsure.auth.model.data.SalesChannelPermissionDO;
import com.ybinsure.auth.model.data.SalesChannelPermissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SalesChannelPermissionDOMapper {
    long countByExample(SalesChannelPermissionDOExample example);

    int deleteByExample(SalesChannelPermissionDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalesChannelPermissionDO record);

    int insertSelective(SalesChannelPermissionDO record);

    List<SalesChannelPermissionDO> selectByExample(SalesChannelPermissionDOExample example);

    SalesChannelPermissionDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalesChannelPermissionDO record, @Param("example") SalesChannelPermissionDOExample example);

    int updateByExample(@Param("record") SalesChannelPermissionDO record, @Param("example") SalesChannelPermissionDOExample example);

    int updateByPrimaryKeySelective(SalesChannelPermissionDO record);

    int updateByPrimaryKey(SalesChannelPermissionDO record);
}