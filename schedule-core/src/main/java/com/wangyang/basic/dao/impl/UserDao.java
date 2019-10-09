package com.wangyang.basic.dao.impl;

import com.wangyang.basic.dao.IUserDao;
import com.wangyang.basic.dao.BaseDao;
import com.wangyang.model.User;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

}
