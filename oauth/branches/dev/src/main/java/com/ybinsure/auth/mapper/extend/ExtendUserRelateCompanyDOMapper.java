package com.ybinsure.auth.mapper.extend;

import com.ybinsure.auth.model.data.UserRelateCompanyDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtendUserRelateCompanyDOMapper {

    List<String> queryUserIdByCompanyId(@Param("userId") String userId);

    Integer insertList(@Param("param")List<UserRelateCompanyDO> param);
}
