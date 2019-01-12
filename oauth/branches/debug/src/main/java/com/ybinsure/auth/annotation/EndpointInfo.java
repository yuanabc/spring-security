package com.ybinsure.auth.annotation;

import com.ybinsure.auth.constant.InterfaceTypeCode;

import java.lang.annotation.*;

/**
 * 标注控制器信息
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EndpointInfo {

    // 描述信息
    String description() default "";

    // 日志分类
    String interfaceType() default InterfaceTypeCode.NON_TYPE;
}
