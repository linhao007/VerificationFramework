package com.linhao007.www;



import com.linhao007.www.annotation.NotNull;
import com.linhao007.www.annotation.ValiateToClass;
import com.linhao007.www.annotation.ValiateToList;
import com.linhao007.www.exception.RequestValidateException;
import com.linhao007.www.innerAnnotationUtils.NotNullValiate;
import com.linhao007.www.innerAnnotationUtils.ToListValiate;

import java.lang.reflect.Field;

/**
 * Created by www.linhao007.com on 2016-8-5.
 * 用于参数校验
 */
public class RequestValidateUtils {
    public static void checkRequest(Object request) throws IllegalAccessException, RequestValidateException {
        ValidateIstrategy validateIstrategy = null;
        Class c1 = request.getClass();
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // 设置些属性是可以访问的
            Object object = field.get(request);//获得属性的值

            boolean isAnnation = field.isAnnotationPresent(NotNull.class);//判断属性是否利用了NotNull的注解

            boolean isAnnationToList = field.isAnnotationPresent(ValiateToList.class);//判断属性是否利用了ValiateToList的注解

            boolean isAnnationToClass = field.isAnnotationPresent(ValiateToClass.class);//判断属性是否利用了ValiateToClass的注解

            //该类属性为基本参数校验
            if (isAnnation) {
                    //获取到该属性的值对应的类
                    validateIstrategy = new ValidateIstrategy(new NotNullValiate());
                    validateIstrategy.operateField(field, object);
            }

            //该类属性为List对象集合参数校验
            if (isAnnationToList) {
                ValiateToList valiateToList = field.getAnnotation(ValiateToList.class);
                if (valiateToList.value()) {
                    validateIstrategy = new ValidateIstrategy(new ToListValiate());
                    validateIstrategy.operateField(object);
                }
            }

            if (isAnnationToClass) {
              ValiateToClass valiateToClass = field.getAnnotation(ValiateToClass.class);
                if (valiateToClass.value()) {
                    checkRequest(object);//递归调用   检查该属性中复杂类型中基本参数是否合法
                }
            }

        }
    }

}
