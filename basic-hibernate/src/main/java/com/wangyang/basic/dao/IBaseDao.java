package com.wangyang.basic.dao;

import com.wangyang.basic.model.Pager;

import java.util.List;
import java.util.Map;

/**
 * 公共的Dao处理对象
 */
public interface IBaseDao<T> {
    /**
     * 添加对象
     * @param t
     * @return
     */
    T add(T t);

    /**
     * 更新对象
     * @param t
     */
    void  update(T t);

    /**
     * 根据id删除对象
     * @param id
     */
    void delete(int id);

    /**
     * 根据id查找对象
     * @param id
     * @return
     */
    T load(int id);

    /**
     * 不分分页的列表对象
     * @param hql 查询对象的hql
     * @param args 查询对象的参数
     * @return 返回一组对象列表
     */
    List<T> list(String hql,Object[] args);
    List<T> list(String hql,Object args);
    List<T> list(String hql);

    /**
     * 基于别名和列表的混合参数查询
     * @param hql
     * @param args
     * @param alias 别名对象
     * @return
     */
    List<T> list(String hql, Object[] args, Map<String,Object> alias);
    List<T> listByAlias(String hql,  Map<String,Object> alias);


    /**
     * 分页的列表对象
     * @param hql 查询对象的hql
     * @param args 查询对象的参数
     * @return 返回一组对象列表
     */
    Pager<T> find(String hql, Object[] args,boolean isIndex);
    Pager<T> find(String hql,Object arg,boolean isIndex);
    Pager<T> find(String hql,boolean isIndex);
    /**
     * 基于别名和列表的混合参数查询
     * @param hql
     * @param args
     * @param alias 别名对象
     * @return
     */
    Pager<T> find(String hql, Object[] args, Map<String,Object> alias,boolean isIndex);
    Pager<T> findByAlias(String hql,  Map<String,Object> alias,boolean isIndex);



    /**
     * 根据hql查询一组对象
     * @param hql
     * @param args
     * @return
     */
    Object queryObject(String hql,Object[] args);
    Object queryObject(String hql,Object arg);
    Object queryObject(String hql);
    Object queryObject(String hql,Object[] args,Map<String,Object> alias);
    Object queryObjectByAlias(String hql,Map<String,Object> alias);

    /**
     * 根据hql更新一组对象
     * @param hql
     * @param args
     */
    void updateByHql(String hql,Object[] args);
    void updateByHql(String hql,Object args);
    void updateByHql(String hql);

    /**
     * 不分页根据sql查询对象，不包含关联查询
     * @param sql
     * @param args 查询条件
     * @param clz   查询对象的实体
     * @param hasEntity 是否是hibernate所管理的实体
     * @return
     */
    <N extends Object>List<N> listBySql(String sql,Object[] args,Class<?> clz,boolean hasEntity);
    <N extends Object>List<N>  listBySql(String sql, Object arg, Class<?> clz, boolean hasEntity);
    <N extends Object>List<N> listBySql(String sql,Class<?> clz,boolean hasEntity);
    <N extends Object>List<N>  listBySql(String sql,Object[] args,Map<String,Object> alias, Class<?> clz,boolean hasEntity);
    <N extends Object>List<N> listByAliasSql(String sql,Map<String,Object> alias, Class<?> clz,boolean hasEntity);

    /**
     * 不分页根据sql查询对象，不包含关联查询
     * @param sql
     * @param args 查询条件
     * @param clz   查询对象的实体
     * @param hasEntity 是否是hibernate所管理的实体
     * @return
     */
    <N extends Object>Pager<N> findBySql(String sql,Object[] args,Class<?> clz,boolean hasEntity,boolean isIndex);
    <N extends Object>Pager<N> findBySql(String sql,Object arg,Class<?> clz,boolean hasEntity,boolean isIndex);
    <N extends Object>Pager<N> findBySql(String sql,Class<?> clz,boolean hasEntity,boolean isIndex);
    <N extends Object>Pager<N> findBySql(String sql,Object[] args,Map<String,Object> alias, Class<?> clz,boolean hasEntity,boolean isIndex);
    <N extends Object>Pager<N> findByAliasSql(String sql,Map<String,Object> alias, Class<?> clz,boolean hasEntity,boolean isIndex);
}

