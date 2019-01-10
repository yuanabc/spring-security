package com.ybinsure.icar.user.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取请求参数
 *
 * @author HANHT
 * @version 2018/7/12 9:49
 */
public class RequestParamsUtil {

    /**
     * application/x-www-form-urlencoded
     *
     * @param request 请求
     * @return map结果
     */
    public static Map<String, String> getRequestMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(16);
        Enumeration<String> em = request.getParameterNames();
        String name, value;
        while (em.hasMoreElements()) {
            name = em.nextElement();
            value = request.getParameter(name);
            map.put(name, StrUtil.trim(value));
        }
        return map;
    }
}
