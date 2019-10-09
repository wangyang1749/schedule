package com.wangyang.test;

import com.wangyang.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TBase2 {
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Session getSession(){
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
    @Transactional
    @Test
    public void find(){
        NativeQuery nativeQuery = getSession().createNativeQuery("select * from t_article");
        List<Article> resultList = (List< Article > )nativeQuery.setFirstResult(1).setMaxResults(5).getResultList();
    }
    @Transactional
    @Test
    public void findPage(){
        NativeQuery queryCount = getSession().createNativeQuery("select count(*) from t_article");
        queryCount.uniqueResult();
        System.out.println("begin-----3");
        //查询所有数据

        NativeQuery nativeQuery = getSession().createNativeQuery("select * from t_article");
        List<Article> resultList = nativeQuery.addEntity(Article.class).setFirstResult(1).setMaxResults(5).getResultList();

        System.out.println("begin-----4");
    }


    @Transactional
    @Test
    public void findPage2(){
        NativeQuery nativeQuery = getSession().createNativeQuery("select * from t_article");
        NativeQuery queryCount = getSession().createNativeQuery("select count(*) from t_article");


        nativeQuery.addEntity(Article.class);


        List<Article> resultList = nativeQuery.setFirstResult(1).setMaxResults(5).getResultList();

        Object objCount = queryCount.uniqueResult();
        int count = Integer.parseInt(objCount.toString());
    }
    @Test
    @Transactional
    public void testHsql(){
        List<Article> list = getSession().createQuery("select art from Article art join fetch art.user join fetch art.grade").list();

    }
}
