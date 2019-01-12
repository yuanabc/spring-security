package com.ybinsure.auth.service.tool;

import org.springframework.http.ResponseEntity;

/**
 * rest请求服务
 */
public interface RestTemplateRequestService {

    /**
     * 使用服务client请求登录
     */
    ResponseEntity<Object> tokenWithServiceClient(String userName, String password);

    /**
     * 使用前端client请求登录
     */
    ResponseEntity<Object> tokenWithFrontClient(String userName, String password);
}
