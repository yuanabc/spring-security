package com.ybinsure.auth.model.transfer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 响应结果
 */
public class Result<T> {

    public static final Integer SUCCESS = 200;
    public static final Integer AUTH_ERROR = 401;
    public static final Integer ERROR = 500;
    public static final Integer NON_OPERATE = 600;

    private static String SUCCESS_MSG = "成功";
    private static String NON_OPERATE_MSG = "操作不成功";
    public static final String AUTH_ERROR_MSG = "身份信息校验不通过!";
    private static final String ERROR_MSG = "连接服务器异常";
    private static final String LOGIN_ERROR_MSG = "用户名或者密码错误";

    private Integer status;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String convertJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

    public static <T> Result<T> success() {
        return new Result<>(SUCCESS, SUCCESS_MSG, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS, SUCCESS_MSG, data);
    }

    public static <T> Result<T> error() {
        return new Result<>(ERROR, ERROR_MSG, null);
    }

    public static <T> Result<T> error(String mes) {
        return new Result<>(ERROR, mes, null);
    }

    public static <T> Result<T> nonError(String msg) {
        return new Result<>(NON_OPERATE, msg, null);
    }

    public static <T> Result<T> nonError() {
        return new Result<>(NON_OPERATE, NON_OPERATE_MSG, null);
    }

    public static <T> Result<T> authError() {
        return new Result<>(AUTH_ERROR, AUTH_ERROR_MSG, null);
    }

    public static <T> Result<T> loginError() {
        return error(LOGIN_ERROR_MSG);
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
