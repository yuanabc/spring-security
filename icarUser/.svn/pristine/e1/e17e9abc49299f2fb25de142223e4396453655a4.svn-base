package com.ybinsure.icar.user.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * actionType 0车型查询， 1为报价，2为核保，3为申请支付，4承保回调,5支付成功后回调，6为撤单
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {

    String description() default "";

    int actionType() default -1;
}