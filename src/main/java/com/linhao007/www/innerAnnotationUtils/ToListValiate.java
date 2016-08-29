package com.linhao007.www.innerAnnotationUtils;




import com.linhao007.www.IStrategy;
import com.linhao007.www.ValidateIstrategy;
import com.linhao007.www.annotation.NotNull;
import com.linhao007.www.exception.RequestValidateException;
import com.linhao007.www.utils.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by daojialinhu01 on 2016-8-10.
 * 校验属性类型为List集合中的数据对象是否为空
 */
public class ToListValiate implements IStrategy {

    public void valiate(Object object) throws RequestValidateException, IllegalAccessException {
        ValidateIstrategy validateIstrategy = null;
        for (Object obj : (List) object) {
            if (obj == null || StringUtils.isNumeric(obj)) {
                throw new RequestValidateException("属性：" + obj.getClass().getName() + "不能为空");
            } else {
                Class<? extends Object> class1 = obj.getClass();
                Field[] fields = class1.getDeclaredFields();//获得List集合中的对象中的属性值
                for (Field field : fields) {
                    field.setAccessible(true); // 设置些属性是可以访问的
                    Object listObject = field.get(obj);
                    boolean isAnnation = field.isAnnotationPresent(NotNull.class);//判断属性是否利用了NotNull的注解
                    if (isAnnation) {
                        validateIstrategy = new ValidateIstrategy(new NotNullValiate());
                        validateIstrategy.operateField(field, listObject);
                    }
                }
            }
        }
    }

    public void valiate(Field field, Object object) throws RequestValidateException, IllegalAccessException {

    }
}
