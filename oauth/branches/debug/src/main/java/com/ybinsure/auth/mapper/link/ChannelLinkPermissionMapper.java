package com.ybinsure.auth.mapper.link;

import com.ybinsure.auth.model.data.PermissionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChannelLinkPermissionMapper {

    List<PermissionDO> queryByChannelCode(@Param("channelCode") String channelCode);
}
