package com.wangyang.basic.dao;

import com.wangyang.basic.model.Pager;
import com.wangyang.basic.model.SystemContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseDao<T> implements  IBaseDao<T> {


    @Inject
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    Class<T> cla ;
    private Class<T> getCla() {
        if(cla==null){
            cla=   (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
        }
        return cla;
    }

    @Override
    public T add(T t) {
        getSession().save(t);
        return t;
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public void delete(int id) {
        getSession().delete(this.load(id));
    }

    @Override
    public T load(int id) {
        return getSession().load(getCla(),id);
    }

    @Override
    public List<T> list(String hql, Object[] args) {
        return this.list(hql,args,null);
    }

    @Override
    public List<T> list(String hql, Object args) {
        return this.list(hql,new Object[]{args});
    }

    @Override
    public List<T> list(String hql) {
        return this.list(hql,null);
    }

    /**
     * 初始化排序
     * @param hql
     * @return
     */
    private String initSort(String hql){
        String order = SystemContext.getOrder();
        String sort = SystemContext.getSort();
        if(sort!=null&&!"".equals(sort.trim())){
            hql+=" order by "+sort;
            if(!"desc".equals(order))hql+=" asc";
            else hql+=" desc";
        }
        return hql;
    }

    /**
     * 设置别名参数
     * @param query
     * @param alias
     */
    private void setParamenterAlias(Query query,Map<String, Object> alias){
        if(alias!=null){
            Set<String> keys = alias.keySet();
            for(String key:keys){
                Object value = alias.get(key);
                if(value instanceof Collection){
                    query.setParameterList(key,(Collection) value);
                }else{
                    query.setParameter(key,value);
                }
            }
        }
    }

    /**
     * 设置普通参数
     * @param query
     * @param args
     */
    private void setParamenter(Query query,Object[] args){
        if(args!=null){
            int index =0;
            for(Object arg:args){
                query.setParameter(index++,arg);
            }
        }
    }

    @Override
    public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
        hql=initSort(hql);
        Query query = getSession().createQuery(hql);
        setParamenterAlias(query,alias);
        setParamenter(query,args);
        List<T> list = query.list();

        return list;
    }

    @Override
    public List<T> listByAlias(String hql, Map<String, Object> alias) {
        return this.list(hql,null,alias);
    }

    @Override
    public Pager<T> find(String hql, Object[] args,boolean isIndex) {
        return this.find(hql,args,null,isIndex);
    }

    @Override
    public Pager<T> find(String hql, Object arg,boolean isIndex) {
        return this.find(hql,new Object[]{arg},isIndex);
    }

    @Override
    public Pager<T> find(String hql,boolean isIndex) {
        return this.find(hql,null,isIndex);
    }

    @Override
    public Pager<T> find(String hql, Object[] args, Map<String, Object> alias,boolean isIndex) {
        hql= initSort(hql);
        String cq = getCountHql(hql,true);
        Query query = getSession().createQuery(hql);
        Query cquery = getSession().createQuery(cq);
        //设置别名
        setParamenterAlias(query,alias);
        setParamenterAlias(cquery,alias);
        //设置参数
        setParamenter(query,args);
        setParamenter(cquery,args);
        long total =(long)cquery.uniqueResult();
        Pager<T> pager = new Pager<T>();
        setPagers(query,pager, total,isIndex);
        pager.setDatas(query.list());
        return pager;
    }

    private String getCountHql(String hql,boolean hasHsql) {
        String e = hql.substring(hql.indexOf("from"));
        String s = "select count(*) "+ e;
        if(hasHsql)s.replace("fetch","");
        return s;
    }


    private void setPagers(Query query,Pager pager,long total,boolean isIndex) {
        int startPage;
        Integer size = SystemContext.getPageSize();
        if(size==null||size<0)size=15;
        long totalPage;
        if(total%size==0){
            totalPage = total/size;
        }else{
            totalPage=total/size+1;
        }
        pager.setTotalPage(totalPage);
        if(isIndex){
            //如果传入的时第几页，不是从第几页开始
            Integer pageIndex = SystemContext.getPageIndex();
            if(pageIndex==null||pageIndex<0)pageIndex=1;
            startPage = (pageIndex-1)*size;
        }else{
            Integer offset = SystemContext.getPageOffset();
            if(offset==null||offset<0)offset=0;
            startPage = offset;
            pager.setOffset(offset);
        }
        pager.setSize(size);
        pager.setTotal(total);
        query.setFirstResult(startPage).setMaxResults(size);
    }

    @Override
    public Pager<T> findByAlias(String hql, Map<String, Object> alias,boolean isIndex) {
        return this.find(hql,null,alias,isIndex);
    }

    @Override
    public Object queryObject(String hql, Object[] args) {
        return queryObject(hql,args,null);
    }

    @Override
    public Object queryObject(String hql, Object arg) {
        return queryObject(hql,new Object[]{arg});
    }

    @Override
    public Object queryObject(String hql) {
        return queryObject(hql,null);
    }

    @Override
    public Object queryObject(String hql, Object[] args, Map<String, Object> alias) {
        Query query = getSession().createQuery(hql);
        setParamenterAlias(query,alias);
        setParamenter(query,args);
        return query.uniqueResult();
    }

    @Override
    public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
        return queryObject(hql,null,alias);
    }

    @Override
    public void updateByHql(String hql, Object[] args) {
        Query query = getSession().createQuery(hql);
        setParamenter(query,args);
        query.executeUpdate();
    }

    @Override
    public void updateByHql(String hql, Object args) {
        updateByHql(hql,new Object[]{args});
    }

    @Override
    public void updateByHql(String hql) {
        updateByHql(hql,null);
    }

    @Override
    public  <N extends Object>List<N> listBySql(String sql, Object[] args, Class<?> clz, boolean hasEntity) {
        return listBySql(sql,args,null,clz,hasEntity);
    }

    @Override
    public  <N extends Object>List<N> listBySql(String sql, Object arg, Class<?> clz, boolean hasEntity) {
        return listBySql(sql,new Object[]{arg},clz,hasEntity);
    }

    @Override
    public  <N extends Object>List<N> listBySql(String sql, Class<?> clz, boolean hasEntity) {
        return listBySql(sql,null,clz,hasEntity);
    }

    @Override
    public  <N extends Object>List<N> listBySql(String sql, Object[] args, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
        sql = initSort(sql);
        NativeQuery sqlQuery =getSession().createNativeQuery(sql);
        setParamenterAlias(sqlQuery,alias);
        setParamenter(sqlQuery,args);
        if(hasEntity){
            sqlQuery.addEntity(clz);
        }else{
//            sqlQuery.unwrap(clz).
        }
        return sqlQuery.list();
    }

    @Override
    public  <N extends Object>List<N> listByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
        return listBySql(sql,null,alias,clz,hasEntity);
    }

    @Override
    public <N extends Object>Pager<N> findBySql(String sql, Object[] args, Class<?> clz, boolean hasEntity,boolean isIndex) {
        return findBySql(sql,args,null,clz,hasEntity,isIndex);
    }

    @Override
    public <N extends Object>Pager<N> findBySql(String sql, Object arg, Class<?> clz, boolean hasEntity,boolean isIndex) {
        return findBySql(sql,new Object[]{arg},clz,hasEntity,isIndex);
    }

    @Override
    public <N extends Object>Pager<N> findBySql(String sql, Class<?> clz, boolean hasEntity,boolean isIndex) {
        return findBySql(sql,null,clz,hasEntity,isIndex);
    }

    @Override
    public <N extends Object>Pager<N> findBySql(String sql, Object[] args, Map<String, Object> alias, Class<?> clz, boolean hasEntity,boolean isIndex) {
        sql = initSort(sql);
        String csql = getCountHql(sql,false);
        NativeQuery cq = getSession().createNativeQuery(csql);
        NativeQuery nativeQuery = getSession().createNativeQuery(sql);
        //设置别名参数
        setParamenterAlias(cq,alias);
        setParamenterAlias(nativeQuery,alias);
        //设置普通参数
        setParamenter(cq,args);
        setParamenter(nativeQuery,args);

        if(hasEntity){
            nativeQuery.addEntity(clz);
        }else{
//            sqlQuery.unwrap(clz).
        }

        long total = ((BigInteger)cq.uniqueResult()).longValue();
        Pager<N> pager = new Pager<N>();
        setPagers(nativeQuery, pager,total,isIndex);
        pager.setDatas(nativeQuery.list());
        return pager;
    }

    @Override
    public <N extends Object>Pager<N> findByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity,boolean isIndex) {
        return findBySql(sql,null,alias,clz,hasEntity,isIndex);
    }
}
