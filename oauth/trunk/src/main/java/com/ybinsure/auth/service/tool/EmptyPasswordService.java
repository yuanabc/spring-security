package com.ybinsure.auth.service.tool;

import com.ybinsure.auth.model.data.UserDO;

import java.util.Optional;

/**
 * 用户空密码操作
 */
public interface EmptyPasswordService {

    Optional<String> getCryptDefaultPassword(String userId);

    String getDefaultPassword();

    void setDefaultPassword(UserDO param);

    void storeCryptDefaultPassword(String userId);

}
