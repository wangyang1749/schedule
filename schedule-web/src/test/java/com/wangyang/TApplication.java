package com.wangyang;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TApplication {
    private static final BeanFactory factory  = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) {
       IUserService userService= (IUserService)factory.getBean("userService");



    }
}
