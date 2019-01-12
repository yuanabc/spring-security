package com.ybinsure.auth.bean.security;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 自定义验证异常
 */
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
class CustomAuthException extends OAuth2Exception {

    static final CustomAuthException defaultInstance = new CustomAuthException();

    private CustomAuthException() {
        super("");
    }
}
