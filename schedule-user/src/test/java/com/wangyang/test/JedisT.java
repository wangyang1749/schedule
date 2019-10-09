package com.wangyang.test;

import com.wangyang.user.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;


//@RunWith(SpringJUnit4ClassRunner.class)

public class JedisT {

    @Autowired
    IUserService userService;


    @Test
    public void testJedis(){
        redis.clients.jedis.Jedis jedis = new redis.clients.jedis.Jedis("192.168.1.151",6379);

        jedis.set("test","123");

        String test = jedis.get("test");

        System.out.println(test);

        jedis.close();
    }
    @Test
    public void test01(){
        userService.login(1);
    }

    @Test
    public void test02(){
        JedisPool jedisPool = new JedisPool("192.168.1.151",6379);
        redis.clients.jedis.Jedis resource = jedisPool.getResource();
        resource.set("hello","1234789900");
    }
}



