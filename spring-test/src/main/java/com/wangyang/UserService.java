package com.wangyang;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    UserDao userDao;
    @Resource(name = "userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
