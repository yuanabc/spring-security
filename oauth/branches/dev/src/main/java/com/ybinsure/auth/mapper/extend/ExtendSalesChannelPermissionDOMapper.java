package com.ybinsure.auth.mapper.extend;

import com.ybinsure.auth.model.data.SalesChannelPermissionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtendSalesChannelPermissionDOMapper {

    Integer insertList(@Param("param")List<SalesChannelPermissionDO> param);
}
