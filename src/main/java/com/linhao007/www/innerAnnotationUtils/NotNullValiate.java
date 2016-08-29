package com.linhao007.www.innerAnnotationUtils;



import com.linhao007.www.IStrategy;
import com.linhao007.www.annotation.NotNull;
import com.linhao007.www.enums.ConstantEnum;
import com.linhao007.www.exception.RequestValidateException;
import com.linhao007.www.utils.StringUtils;

import java.lang.reflect.Field;

/**
 * Created by www.linhao007.com on 2016-8-10.
 * 校验基本字段属性是否为空
 */
public class NotNullValiate implements IStrategy {
    public void valiate(Object object) {

    }

    public void valiate(Field field, Object object) throws RequestValidateException, IllegalAccessException {
        //获取到该属性的值对应的类
        NotNull notNull = field.getAnnotation(NotNull.class);//获取注解字段内的值  判断是否执行字段参数校验
        Class<? extends Object> fieldclass = null;
        try {
            fieldclass = object.getClass();
        } catch (Exception e) {
            throw new RequestValidateException("属性：" + notNull.message());
        }
        String simpleName = fieldclass.getSimpleName();
        //如果是基本类型  则判断是否打上@NotNull标记
        if (ConstantEnum.getConstantTypeByName(simpleName) ||
                simpleName.equals(ConstantEnum.DAOJIA_STRING.getType()) ||
                simpleName.equals(ConstantEnum.DAOJIA_DATE.getType())) {  //如果是基本类型  则判断是否为空
            if (StringUtils.isEmpty(String.valueOf(object))) {
                throw new RequestValidateException("属性：" + notNull.message());
            }
        }
    }
}
