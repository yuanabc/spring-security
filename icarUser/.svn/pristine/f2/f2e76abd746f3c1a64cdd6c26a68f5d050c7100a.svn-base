package com.ybinsure.icar.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 自定义响应结构
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ICarResult<T> {

    /** 响应业务状态 */
    private Integer status;

    /** 响应消息 */
    private String message;

    /** 响应中的数据 */
    private T data;

    public ICarResult() {

    }

    public ICarResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ICarResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ICarResult<T> ok() {
        return new ICarResult<>(RespInfo.SUCCESS.code, RespInfo.SUCCESS.msg);
    }

    public static <T> ICarResult<T> ok(T data) {
        return new ICarResult<>(RespInfo.SUCCESS.code, RespInfo.SUCCESS.msg, data);
    }

    public static <T> ICarResult<T> fail() {
        return new ICarResult<>(RespInfo.FAIL.code, RespInfo.FAIL.msg);
    }

    public static <T> ICarResult<T> noData() {
        return new ICarResult<>(RespInfo.NO_DATA.code, RespInfo.NO_DATA.msg);
    }

    public static <T> ICarResult<T> build(String message) {
        return new ICarResult<>(RespInfo.FAIL.code, message);
    }

    public static <T> ICarResult<T> build(Integer status, String message) {
        return new ICarResult<>(status, message);
    }

    public static <T> ICarResult<T> build(Integer status, String message, T data) {
        return new ICarResult<>(status, message, data);
    }

    public static <T> ICarResult<T> build(RespInfo resp) {
        return new ICarResult<>(resp.code, resp.msg);
    }

    public static <T> ICarResult<T> build(RespInfo resp, T data) {
        return new ICarResult<>(resp.code, resp.msg, data);
    }

    public void change(String message) {
        this.status = RespInfo.FAIL.code;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
