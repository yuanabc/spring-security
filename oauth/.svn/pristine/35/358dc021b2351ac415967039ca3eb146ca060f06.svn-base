package com.ybinsure.auth.mapper.extend;

import com.ybinsure.auth.model.data.ChannelDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtendChannelMapper {

    Integer queryMaxOrderCode();

    List<ChannelDO> queryAll(@Param("status") Byte status, @Param("deleted") Byte deleted);
}
