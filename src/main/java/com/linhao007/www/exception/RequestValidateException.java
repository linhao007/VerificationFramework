package com.linhao007.www.exception;

/**
 * Created by www.linhao007.com on 2016-8-4.
 * 反射获得对象的值以及属性  从而判断是否为空
 */
public class RequestValidateException extends RuntimeException {
    public RequestValidateException(String message) {
        super(message);
    }
}
