package com.wangyang.user.dao.impl;

import com.wangyang.basic.dao.BaseDao;
import com.wangyang.user.dao.IUserDao;
import com.wangyang.user.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {


}
