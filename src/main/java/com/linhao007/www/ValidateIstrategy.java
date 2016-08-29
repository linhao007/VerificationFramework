package com.linhao007.www;



import com.linhao007.www.exception.RequestValidateException;

import java.lang.reflect.Field;

/**
 * Created by www.linhao007.com on 2016-8-10.
 * 策略模式  环境对象  控制使用哪种注解进行检验
 */
public class ValidateIstrategy {

    private IStrategy iStrategy;

    //构造函数，要你使用哪个策略
    public ValidateIstrategy(IStrategy strategy) {
        this.iStrategy = strategy;
    }

    /**
     * 代理操作
     * @param object
     * @return
     */
    public void operateField(Object object) throws RequestValidateException, IllegalAccessException {
        this.iStrategy.valiate(object);
    }

    /**
     * 代理操作
     * @param object
     * @return
     */
    public void operateField(Field field, Object object) throws RequestValidateException, IllegalAccessException {
        this.iStrategy.valiate(field,object);
    }

}
