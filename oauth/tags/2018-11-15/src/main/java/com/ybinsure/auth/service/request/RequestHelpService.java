package com.ybinsure.auth.service.request;

import org.springframework.http.HttpHeaders;

public interface RequestHelpService {

    /**
     * 获取带有令牌的请求信息
     */
    HttpHeaders getHeaders();
}
