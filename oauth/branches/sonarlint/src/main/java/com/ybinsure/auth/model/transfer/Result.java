package com.ybinsure.auth.model.transfer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 响应结果
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "统一响应结果")
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

    @ApiModelProperty(value = "结果状态码，标注业务处理状态。200-成功，401-身份验证不通过，500-服务异常，600-操作不成功，大多因为参数数据不存在")
    private Integer status;

    @ApiModelProperty(value = "状态消息")
    private String msg;

    @ApiModelProperty(value = "响应结果数据,类型T")
    private T data;

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

}
