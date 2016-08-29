package com.linhao007.www.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by www.linhao007.com on 2016-8-5.
 * 用于判断对象必填字段是否为空
 */

/**
 * 并且由于注解有三个生命周期  source class 内存中的二进制   编译器在进行将source转换成class和将class转换为内存里的二进制
 * 编码的时候都可能把注解丢掉 故设置为生命周期一直到运行期  也就是内存里的二进制时期
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})  //作用于属性上
public @interface NotNull {
    String message() default "";
}



