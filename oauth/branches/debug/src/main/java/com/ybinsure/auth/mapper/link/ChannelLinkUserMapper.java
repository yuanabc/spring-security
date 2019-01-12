package com.ybinsure.auth.mapper.link;

import com.ybinsure.auth.model.link.ChannelExtend;
import org.apache.ibatis.annotations.Param;

public interface ChannelLinkUserMapper {

    ChannelExtend query(@Param("id") String id, @Param("userType") String userType);
}
