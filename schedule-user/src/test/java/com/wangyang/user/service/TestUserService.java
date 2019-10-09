package com.wangyang.user.service;

import com.wangyang.basic.model.Pager;
import com.wangyang.user.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestUserService {

    @Resource
    IUserService userService;

    @Test
    public void test(){
        Pager<User> userPager = userService.find("");
        System.out.println(userPager.getDatas().size());
    }
}
