package com.ybinsure.icar.user.exception;

import com.ybinsure.icar.user.constant.RespInfo;

/**
 * 身份认证异常
 *
 * @author HANHT
 * @version 2018/7/11 9:47
 */
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
    }

    /**
     * 身份认证失败
     */
    public static AuthenticationException unauthorized() {

        return new AuthenticationException(RespInfo.F401.msg);
    }

    /**
     * 身份认证失败
     */
    public static AuthenticationException failure() {

        return new AuthenticationException(RespInfo.F530.msg);
    }
}
