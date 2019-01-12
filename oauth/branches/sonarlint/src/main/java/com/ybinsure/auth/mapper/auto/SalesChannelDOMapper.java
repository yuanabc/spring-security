package com.ybinsure.auth.mapper.auto;

import com.ybinsure.auth.model.data.SalesChannelDO;
import com.ybinsure.auth.model.data.SalesChannelDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SalesChannelDOMapper {
    long countByExample(SalesChannelDOExample example);

    int deleteByExample(SalesChannelDOExample example);

    int insert(SalesChannelDO record);

    int insertSelective(SalesChannelDO record);

    List<SalesChannelDO> selectByExample(SalesChannelDOExample example);

    int updateByExampleSelective(@Param("record") SalesChannelDO record, @Param("example") SalesChannelDOExample example);

    int updateByExample(@Param("record") SalesChannelDO record, @Param("example") SalesChannelDOExample example);
}