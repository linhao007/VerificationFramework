package com.linhao007.www.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by www.linhao007.com on 2016-8-8.
 * 用于作用于属性为自定义类型上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ValiateToClass {
    boolean value() default false;
}


