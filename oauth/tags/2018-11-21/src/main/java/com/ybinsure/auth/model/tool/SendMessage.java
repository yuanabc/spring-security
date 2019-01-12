package com.ybinsure.auth.model.tool;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送
 */
public class SendMessage {

    // 发送url
    private String url;

    // api key
    private String key;

    // 手机号
    private String mobile;

    // 发送文本
    private String text;

    public SendMessage() {
    }

    public Map<String, String> convertParam() {
        Map<String, String> param = new HashMap<>();
        param.put("apikey", getKey());
        param.put("mobile", getMobile());
        param.put("text", getText());
        return param;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
