package com.wangyang.user.service;


import com.wangyang.basic.model.Pager;
import com.wangyang.user.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserService {
    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 跟据id查找用户
     * @param id
     * @return
     */
    User load(int id);

    /**
     * 用户登录
     * @return
     */
    String login(int id);

    /**
     * 同过token获取用户信息
     * @return
     */
    User getUserByToken(String token);

    /**
     * 根据id删除用户
     * @param id
     */
    void delete(int id);



    /**
     * 更新用户
     * @param user
     */
    void update(User user);


    /**
     * 用户分页
     * @param condition
     * @return List
     */
    Pager<User> find(String condition);
}
