package com.ybinsure.auth.service.tool;

import com.ybinsure.auth.model.data.UserDO;

import java.util.Optional;

/**
 * 手机号码登录
 */
public interface UserNameLoginService {

    Optional<UserDO> queryOrInsert(UserDO userDO, String companyCode);
}
