package com.linhao007.www.TestPersion;

import com.linhao007.www.annotation.NotNull;
import com.linhao007.www.annotation.ValiateToClass;
import com.linhao007.www.annotation.ValiateToList;

import java.util.List;

/**
 * Created by www.linhao007.com on 2016-8-29.
 */
public class Persion {

    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message="年龄不能为空")
    private Integer age;

    private String sex;

    @ValiateToList(value = true)
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
