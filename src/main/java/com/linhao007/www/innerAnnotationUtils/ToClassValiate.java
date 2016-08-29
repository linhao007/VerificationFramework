package com.linhao007.www.innerAnnotationUtils;



import com.linhao007.www.IStrategy;
import com.linhao007.www.exception.RequestValidateException;

import java.lang.reflect.Field;

/**
 * Created by www.linhao007.com on 2016-8-10.
 * 校验属性类型为自定义复杂类型参数是否为空
 */
public class ToClassValiate implements IStrategy {
    public void valiate(Object object) {

    }

    public void valiate(Field field, Object object) throws RequestValidateException, IllegalAccessException {

    }
}
