package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.SalesChannelDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomSalesChannelDOMapper {

    int insertList(@Param("param")List<SalesChannelDO> param);
}
