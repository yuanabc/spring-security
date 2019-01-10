package com.ybinsure.icar.user.filter;

import com.ybinsure.icar.user.constant.CacheKey;
import com.ybinsure.icar.user.util.MDCUtil;
import org.slf4j.MDC;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 处理日志线程号
 *
 * @author HANHT
 * @version 2018/6/13 15:49
 */
@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        // 根据ip随机算法得到线程号
        String requestId = MDCUtil.getRandomId(req);
        if ("".equals(requestId)) {
            requestId = String.valueOf(System.currentTimeMillis());
        }

        MDC.put(CacheKey.LOG, requestId);
        try {
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    @Override
    public void destroy() {
    }
}
