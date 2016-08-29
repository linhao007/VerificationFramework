package com.linhao007.www;

import com.linhao007.www.TestPersion.Persion;
import com.linhao007.www.TestPersion.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www.linhao007.com on 2016-8-29.
 */
public class VerificationTestMain {

    @Test
    public void testPersion() throws IllegalAccessException {
        Persion persion = new Persion();
        persion.setSex("man");
        persion.setAge(18);
        persion.setName("linhao007");
        User user = new User();
        user.setName("linhao007");
        user.setAge("");
        List<User> lists = new ArrayList<User>();
        lists.add(user);
        persion.setUser(lists);
        RequestValidateUtils.checkRequest(persion);
    }
}
