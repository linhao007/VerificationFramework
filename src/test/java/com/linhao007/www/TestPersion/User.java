package com.linhao007.www.TestPersion;

import com.linhao007.www.annotation.NotNull;

/**
 * Created by www.linhao007.com on 2016-8-29.
 */
public class User {

    @NotNull(message = "user对象的姓名不能为空")
    private String name;
    @NotNull(message = "user对象的芳龄不能为空")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
