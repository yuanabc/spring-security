package com.ybinsure.icar.user.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 获取spring context 内容
 */
@Component
public class SpringContextUtil implements ApplicationContextAware, DisposableBean {

    private static Logger logger = LoggerFactory.getLogger(SpringContextUtil.class);

    private static ApplicationContext applicationContext;

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext != null) {
            logger.info("注入applicationContext");
            SpringContextUtil.applicationContext = applicationContext;
        }
    }

    @Override
    public void destroy() throws Exception {
        SpringContextUtil.clearHolder();
    }

    /**
     * 清除SpringContextHolder中的ApplicationContext为Null.
     */
    private static void clearHolder() {
        logger.debug("清除SpringContextHolder中的ApplicationContext：{}", applicationContext);
        applicationContext = null;
    }

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        Assert.notNull(applicationContext, "ApplicationContext注入失败.");
    }
}
