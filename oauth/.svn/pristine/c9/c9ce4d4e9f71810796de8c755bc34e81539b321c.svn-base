package com.ybinsure.auth.mapper.link;

import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.UserExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLinkPermissionMapper {

    List<UserExtend> queryByUserName(@Param("param")UserDO param);

    List<PermissionDO> queryByUserId(@Param("param")UserDO param);

}
