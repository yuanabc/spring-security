package com.ybinsure.auth.mapper.extend;

import com.ybinsure.auth.model.data.UserRelateRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtendUserRelateRoleDOMapper {

    Integer insertList(@Param("param")List<UserRelateRoleDO> param);
}
