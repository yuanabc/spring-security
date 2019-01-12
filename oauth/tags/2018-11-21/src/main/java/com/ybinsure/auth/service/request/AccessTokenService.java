package com.ybinsure.auth.service.request;

public interface AccessTokenService {

    /**
     * 获取登录令牌
     */
    String getAccessToken();

    /**
     * 刷新登录令牌
     */
    void refreshAccessToken();
}
