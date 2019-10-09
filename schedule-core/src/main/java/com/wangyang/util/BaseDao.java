package com.wangyang.util;

import com.wangyang.model.PagerAjax;
import com.wangyang.model.Pager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseDao<T> implements IBaseDao<T>{

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Session getSession(){
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    Class<T> cla ;
    private Class<T> getCla() {
        if(cla==null){
            cla=   (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
        }
        return cla;
    }

    @Override
    public void add(T t) {

        getSession().save(t);
    }

    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    @Override
    public void delete(int id) {
        String hql="delete "+getCla().getSimpleName()+" as o where o.id=:id";
        Query query = getSession().createQuery(hql);
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public T load(int id) {
        T t  =getSession().get(getCla(),id);
        return t;
    }

    @Override
    public List<T> list(String sql,Object... params) {
        NativeQuery nativeQuery = getSession().createNativeQuery(sql);
        for(int i=0;i<params.length;i++){
            int index =i+1;
            nativeQuery.setParameter(index,params[i]);
        }
        List<T> list = nativeQuery.addEntity(getCla()).getResultList();

        return list;
    }

    @Override
    public List<T> list(String sql) {
        List<T> resultList = getSession()
                .createNativeQuery(sql,getCla())
                .getResultList();
        return resultList;
    }

    @Override
    public Pager<T> find(int currentPage) {
        return null;
    }

    @Override
    public PagerAjax<T> find(String sql, String countSql, int pageIndex, Map<String,Object> param) {
        PagerAjax<T> pagerAjax = new PagerAjax<T>();

        NativeQuery nativeQuery = getSession().createNativeQuery(sql);
        NativeQuery queryCount = getSession().createNativeQuery(countSql);
        if(param!=null){
            Set<String> set = param.keySet();
            for(String key : set){
                Object value=param.get(key);
                nativeQuery.setParameter(key,value);
                queryCount.setParameter(key,value);
            }
        }

        //查询所有数据
        nativeQuery.addEntity(getCla());
        List<T> resultList = nativeQuery.setMaxResults(pageIndex).getResultList();

        //查询总记录数
        Object objCount = queryCount.uniqueResult();
        int count = Integer.parseInt(objCount.toString());

        pagerAjax.setDatas(resultList);
        pagerAjax.setTotalRecord(count);
        pagerAjax.setPageIndex(pageIndex);
        return pagerAjax;
    }

    @Override
    public Pager<T> find(String sql, String countSql, int pageIndex, int pageSize,Map<String, Object> param) {
        Pager<T> pager = new Pager<T>();
        NativeQuery nativeQuery = getSession().createNativeQuery(sql);
        NativeQuery queryCount = getSession().createNativeQuery(countSql);
        if(param!=null){
            Set<String> set = param.keySet();
            for(String key : set){
                Object value=param.get(key);
                nativeQuery.setParameter(key,value);
                queryCount.setParameter(key,value);
            }
        }
        //查询所有数据
        nativeQuery.addEntity(getCla());
        int firtPage=(pageIndex-1)*pageSize;

        List<T> resultList = nativeQuery.setFirstResult(firtPage).setMaxResults(pageSize).getResultList();
        //查询总页数
        Object objCount = queryCount.uniqueResult();
        int count = Integer.parseInt(objCount.toString());
        int totalPage;
        if(count%pageSize==0){
            totalPage=count/pageSize;
        }else{
            totalPage=count/pageSize+1;
        }
        pager.setData(resultList);
        pager.setTotalRecord(count);
        pager.setPageIndex(pageIndex);
        pager.setPageSize(pageSize);
        pager.setTotalPage(totalPage);
        return pager;
    }

    @Override
    public Pager<T> findHsql(String hsql, String countSql, int pageIndex, int pageSize, Map<String, Object> param) {
        Pager<T> pager = new Pager<T>();
        Query query = getSession().createQuery(hsql);
        NativeQuery queryCount = getSession().createNativeQuery(countSql);
        if(param!=null){
            Set<String> set = param.keySet();
            for(String key : set){
                Object value=param.get(key);
                query.setParameter(key,value);
                queryCount.setParameter(key,value);
            }
        }
        //查询所有数据
        int firtPage=(pageIndex-1)*pageSize;

        List<T> resultList = query.setFirstResult(firtPage).setMaxResults(pageSize).list();
        //查询总页数
        Object objCount = queryCount.uniqueResult();
        int count = Integer.parseInt(objCount.toString());
        int totalPage;
        if(count%pageSize==0){
            totalPage=count/pageSize;
        }else{
            totalPage=count/pageSize+1;
        }
        pager.setData(resultList);
        pager.setTotalRecord(count);
        pager.setPageIndex(pageIndex);
        pager.setPageSize(pageSize);
        pager.setTotalPage(totalPage);
        return pager;
    }

    @Override
    public List<Object[]> findStr(String hsql, Map<String, Object> maps) {
        Query query = getSession().createQuery(hsql);
        Set<String> keys = maps.keySet();
        for(String key : keys){
            Object value = maps.get(key);
            query.setParameter(key,value);
        }
        List<Object[]> list = query.list();
        return list;
    }
}
