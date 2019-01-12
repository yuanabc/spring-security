package com.ybinsure.auth.exception;


import com.ybinsure.auth.model.transfer.Result;

/**
 * 终止流程,返回执行结果到前端
 * Created by eric on 2017/7/3.
 */
public class ReturnResultException extends RuntimeException {

    private Result result;

    public ReturnResultException() {
    }

    private ReturnResultException(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    /**
     * 登录失败
     */
    public static ReturnResultException loginErrorInstance() {
        return new ReturnResultException(Result.loginError());
    }

    /**
     * token校验失败
     */
    public static ReturnResultException authErrorInstance() {
        return new ReturnResultException(Result.authError());
    }

    /**
     * 操作不成功
     */
    public static ReturnResultException nonErrorInstance() {
        return new ReturnResultException(Result.nonError());
    }
}
