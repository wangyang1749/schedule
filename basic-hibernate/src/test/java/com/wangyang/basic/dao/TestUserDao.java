package com.wangyang.basic.dao;

import com.wangyang.basic.model.Pager;
import com.wangyang.basic.model.SystemContext;
import com.wangyang.basic.model.User;
import com.wangyang.basic.util.InitData;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;


import javax.inject.Inject;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestUserDao {

    @Inject
    IUserDao userDao;

    @Inject
    SessionFactory sessionFactory;

    @BeforeClass
    public static void init() throws SQLException {
        InitData.insertData();
        System.out.println("初始化");
    }
    @Before
    public void setUp(){
        TransactionSynchronizationManager.bindResource(sessionFactory,new SessionHolder(sessionFactory.openSession()));
    }

    @After
    public void tdown() throws SQLException {
//        SessionHolder resource = (SessionHolder)TransactionSynchronizationManager.getResource(sessionFactory);
//        Session session = resource.getSession();
//        session.flush();
        TransactionSynchronizationManager.unbindResource(sessionFactory);
        System.out.println("还原数据！！！");
        InitData.insertData();
    }
    /**
     * 测试添加
     */
    @Test
    public void testAdd() {
        System.out.println("添加用户！！");
        userDao.add(new User("张三","123456"));
    }
    @Test(expected = ObjectNotFoundException.class)
    public void testDelete(){
        System.out.println("删除用户！！");
        userDao.delete(1);
        User load = userDao.load(1);
        System.out.println(load);
    }
    @Test
    public void load(){
        User load = userDao.load(1);
        System.out.println(load);
    }
    @Test
    public  void  list(){
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        List<User> list = userDao.list("from User where id>?0 and id<?1", new Object[]{1, 5});
//        List<User> list2 = Arrays.asList(new User(2),new User(1));
        assertEquals(list.size(),3);
        assertEquals(list.get(0).getId(),4);
    }
    @Test
    public  void  listAlias(){
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        Map<String,Object> map = new HashMap<>();
        map.put("ids",Arrays.asList(1,2,3,5,6));
        List<User> list = userDao.list("from User where id>?0 and id<?1 and id in(:ids)", new Object[]{1, 5},map);
//        List<User> list2 = Arrays.asList(new User(2),new User(1));
        assertEquals(list.size(),2);
        assertEquals(list.get(0).getId(),3);
    }
    @Test
    public  void  findByArgs(){
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        SystemContext.setPageSize(10);
        SystemContext.setPageOffset(0);
        Pager<User> pager = userDao.find("from User where id>?0 and id<?1", new Object[]{1, 5},false);
        assertEquals(pager.getSize(),10);
        assertEquals(pager.getTotal(),3);

        assertEquals(pager.getDatas().get(0).getId(),4);
    }
    @Test
    public  void  listBySqlArgs(){
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        SystemContext.setPageSize(10);
        SystemContext.setPageOffset(0);
        List<User> list = userDao.listBySql("select * from t_user where id>?0 and id<?1", new Object[]{1, 5}, User.class, true);
        assertEquals(list.size(),3);
        assertEquals(list.get(0).getId(),4);
    }
    @Test
    public  void  findsBySqlArgs(){
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        SystemContext.setPageSize(10);
        SystemContext.setPageOffset(0);
        Pager<User> pager = userDao.findBySql("select * from t_user where id>?0 and id<?1", new Object[]{1, 5},User.class,true,false);
        assertEquals(pager.getSize(),10);
        assertEquals(pager.getTotal(),3);

        assertEquals(pager.getDatas().get(0).getId(),4);
    }
    @Test
    public  void  findsBySqlArgsIsPageIndex(){
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        SystemContext.setPageSize(10);
        SystemContext.setPageIndex(1);
        Pager<User> pager = userDao.findBySql("select * from t_user where id>?0 and id<?1", new Object[]{1, 20},User.class,true,true);
        assertEquals(pager.getSize(),10);
//        System.out.println(pager.getDatas().size());
//        assertEquals(pager.getTotal(),3);
//
        assertEquals(pager.getDatas().get(0).getId(),19);

    }
    @Test
    public  void  find(){
        SystemContext.setSort("id");
        SystemContext.setOrder("desc");
        SystemContext.setPageSize(10);
        SystemContext.setPageOffset(0);
        Pager<User> pager = userDao.find("from User",false);

    }
}
