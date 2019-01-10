package com.ybinsure.icar.user.exception;

import com.ybinsure.icar.user.constant.RespInfo;

/**
 * 异常返回
 */
public class SystemException extends RuntimeException {

    public SystemException(String message) {
        super(message);
    }

    public static SystemException instance(String message) {

        return new SystemException(message);
    }

    public static SystemException exception() {
        return new SystemException(RespInfo.FAIL.msg);
    }

    public static SystemException paramsException() {
        return new SystemException(RespInfo.ABNORMAL_DATA.msg);
    }
}
