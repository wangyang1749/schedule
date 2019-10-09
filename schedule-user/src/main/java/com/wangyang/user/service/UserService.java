package com.wangyang.user.service;


import com.wangyang.basic.model.Pager;
import com.wangyang.basic.model.SystemContext;
import com.wangyang.user.dao.IUserDao;
import com.wangyang.user.model.User;
import com.wangyang.user.model.UserException;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.UUID;

@Service("userService")
public class UserService implements IUserService {

    @Resource(name = "jedisPool")
    JedisPool jedisPool;


    IUserDao userDao;
    @Resource(name = "userDao")

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User load(int id) {
        return userDao.load(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public String login(int id) {
        String token;
        Jedis resource =null;
        try {
            User user = userDao.load(id);
            if(user==null){
                throw new UserException("登录的用户不存在");
            }else{
                System.out.println("登录成功！");
                resource = jedisPool.getResource();
                //存入Session
                token = UUID.randomUUID().toString();
                resource.set("SESSION:"+token, JSONObject.fromObject(user).toString());
                //设置过期时间
                resource.expire("SESSION:"+token,1800);
                resource.close();
            }
        } finally {
            if(resource!=null){
                System.out.println("关闭连接");
                resource.close();
            }
        }
        //返回token
        return token;
    }

    @Override
    public User getUserByToken(String token) {
        User user=null;
        Jedis resource =null;

        try {
            resource =jedisPool.getResource();
            String jsonUser = resource.get("SESSION:"+token);
            if(jsonUser==null||"".equals(jsonUser)){
                System.out.println("redis中不存在用户");
                return null;
            }else{
                resource.expire("SESSION:"+token,1800);
                user = (User) JSONObject.toBean(JSONObject.fromObject(jsonUser), User.class);
            }
        } finally {
            if(resource!=null){
                System.out.println("关闭连接");
                resource.close();
            }
        }
        return user;
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }


    @Override
    public Pager<User> find(String condition) {
        SystemContext.setPageIndex(1);
        SystemContext.setPageSize(10);
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        Pager<User> userPager = userDao.find("from User", true);

        return userPager;
    }

}
