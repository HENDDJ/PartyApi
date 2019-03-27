package com.cloudkeeper.leasing.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 身份认证注解
 * 方法上有效
 * 运行时有效
 * @author jerry
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {

    /** 是否必须 - 默认必须*/
    boolean required() default true;
}
