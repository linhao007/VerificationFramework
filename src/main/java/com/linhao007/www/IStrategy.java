package com.linhao007.www;


import com.linhao007.www.exception.RequestValidateException;

import java.lang.reflect.Field;

/**
 * Created by www.linhao007.com on 2016-8-10.
 */
public interface IStrategy {

    void valiate(Object object) throws RequestValidateException, IllegalAccessException;

    void valiate(Field field, Object object) throws RequestValidateException, IllegalAccessException;
}
