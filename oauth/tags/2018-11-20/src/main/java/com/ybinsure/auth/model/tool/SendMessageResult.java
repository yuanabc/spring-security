package com.ybinsure.auth.model.tool;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 短信响应结果
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendMessageResult {

    // 状态码
    private String code;

    // 状态消息
    private String msg;

    // 详细消息
    private String detail;

    public static String SUCCESS_CODE = "0";

    public SendMessageResult() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
