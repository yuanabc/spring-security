package com.ybinsure.auth.mapper.extend;

import com.ybinsure.auth.model.data.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ExtendUserMapper {

    Long queryMaxCode(@Param("channelCode") String channelCode, @Param("userType") String userType, @Param("min") Long min);

    List<UserDO> queryNotEmptyPasswordUser();

    int updatePassword(@Param("user") UserDO user);

    List<String> queryIdByChannelId(@Param("id") String id);

    UserDO queryFirst(@Param("channelCode") String channelCode);

    List<String> queryLastToken(@Param("ids") List<String> ids);

    List<String> queryLastTokenByTokenNonExpire(@Param("channelCode") String channelCode, @Param("now")Date now);
}
