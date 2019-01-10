package com.ybinsure.icar.user.model.param;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 前端错误信息入参
 *
 * @author HANHT
 * @version 2018/7/12 15:42
 */
public class FrontParam {

    @NotBlank(message = "错误地址不能为空")
    private String url;
    @NotBlank(message = "错误信息不能为空")
    private String message;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
