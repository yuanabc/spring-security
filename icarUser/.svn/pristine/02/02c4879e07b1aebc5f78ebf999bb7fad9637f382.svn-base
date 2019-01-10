package com.ybinsure.icar.user.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置文件设置的常量
 *
 * @author HANHT
 * @version 2018/7/3 14:14
 */
@Component
public class ConfigConst {

    /** 图像识别接口验证token */
    public static String RECOGNIZE_TOKEN;

    /** 调用飞哥核心地址 */
    public static String MAIN_URL;

    /** okhttp 连接超时 */
    public static long CONNECT_TIMEOUT;
    /** okhttp 写数据超时 */
    public static long WRITE_TIMEOUT;
    /** okhttp 读数据超时 */
    public static long READ_TIMEOUT;

    /** 用户认证服务地址 */
    public static String AUTH_URL;

    @Value("${recognize_token:}")
    public void setRecognizeToken(String recognizeToken) {
        RECOGNIZE_TOKEN = recognizeToken;
    }

    @Value("${main_url:}")
    public void setMainUrl(String mainUrl) {
        MAIN_URL = mainUrl;
    }

    @Value("${http.connectTimeout:0}")
    public void setConnectTimeout(long connectTimeout) {
        CONNECT_TIMEOUT = connectTimeout;
    }

    @Value("${http.writeTimeout:0}")
    public void setWriteTimeout(long writeTimeout) {
        WRITE_TIMEOUT = writeTimeout;
    }

    @Value("${http.readTimeout:0}")
    public void setReadTimeout(long readTimeout) {
        READ_TIMEOUT = readTimeout;
    }

    @Value("${auth_url:}")
    public void setAuthUrl(String authUrl) {
        AUTH_URL = authUrl;
    }
}
