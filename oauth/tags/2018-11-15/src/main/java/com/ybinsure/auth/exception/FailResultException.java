package com.ybinsure.auth.exception;


/**
 * 异常结果，需要终止流程
 * Created by eric on 17-5-25.
 */
public class FailResultException extends RuntimeException {

    public FailResultException(String message) {
        super(message);
    }

    public static FailResultException instance(String mes) {
        return new FailResultException(mes);
    }

    public static FailResultException nonError() {
        return nonError("操作不成功");
    }

    public static FailResultException nonError(String message) {
        return new FailResultException(message);
    }

    public static FailResultException convertJsonError() {
        return new FailResultException("json参数转换失败");
    }

    public static FailResultException connectError() {
        return new FailResultException("连接远程服务失败");
    }

    public static FailResultException authError() {
        return new FailResultException("登录失败");
    }

    public static FailResultException userInfoError() {
        return new FailResultException("用户信息异常");
    }

}
