package com.ybinsure.auth.annotation;

import java.lang.annotation.*;

/**
 * 日志入注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DatabaseLogFlag {
}
