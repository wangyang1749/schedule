package com.wangyang;


import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{
    public void show(){
        System.out.println("hello");
    }
}
