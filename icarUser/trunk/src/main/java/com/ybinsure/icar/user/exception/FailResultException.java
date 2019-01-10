package com.ybinsure.icar.user.exception;

import com.ybinsure.icar.user.constant.RespInfo;

/**
 * 异常结果，需要终止流程
 */
public class FailResultException extends RuntimeException {

    public FailResultException(String message) {
        super(message);
    }

    public static FailResultException dataException() {
        return new FailResultException(RespInfo.ABNORMAL_DATA.msg);
    }

    public static FailResultException dataExistException() {
        return new FailResultException(RespInfo.EXIST_DATA.msg);
    }

    public static FailResultException dataNoExistException() {
        return new FailResultException(RespInfo.NO_DATA.msg);
    }

    public static FailResultException connectionException() {
        return new FailResultException(RespInfo.F520.msg);
    }

    public static FailResultException uploadException() {
        return new FailResultException(RespInfo.F525.msg);
    }
}
