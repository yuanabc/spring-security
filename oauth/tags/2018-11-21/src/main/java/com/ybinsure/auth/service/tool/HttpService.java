package com.ybinsure.auth.service.tool;

import java.util.Map;
import java.util.Optional;

/**
 * http服务
 */
//todo 用RestTemplate重构
public interface HttpService {

    /**
     * json方式post数据
     * @param url 请求地址
     * @param data post json数据
     * @param tClass 响应结果类型
     * @param <T> 结构类型
     * @return 请求结果
     */
    <T> Optional<T> postJson(String url, Object data, Class<T> tClass);

    /**
     * encoder方式post数据
     * @param url 请求地址
     * @param data post 数据对
     * @param tClass 响应结果类型
     * @param <T> 结构类型
     * @return 请求结果
     */
    <T> Optional<T> postEncode(String url, Map<String, String> data, Class<T> tClass);

}
