package com.wangyang.util;

import com.wangyang.model.Pager;
import com.wangyang.model.PagerAjax;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface IBaseDao<T> {
    /**
     * 通用的添加
     * @param t
     */
    void add(T t);
    void delete(T t);

    /**
     * 根据id删除
     * @param id
     */
    void delete(int id);
    void update(T t);

    /**
     * 根据id查询对象
     * @param id
     * @return
     */
    T load(int id);

    /**
     * 查找字符串数组的列表
     * @param hsql
     * @param maps
     * @return
     */
    List<Object[]> findStr(String hsql,Map<String,Object> maps);

    List<T> list(String sql,Object... params);
    List<T> list(String sql);
    Pager<T> find(int currentPage);

    /**
     * 通用的分页查询，查询总量ajax
     * @param sql
     * @param param
     * @return
     */
    PagerAjax<T> find(String sql, String countSql, int pageIndex, Map<String,Object> param);

    /**
     * 通用的分页查询，从第几页取几条数据
     * @param sql
     * @param countSql
     * @param pageIndex
     * @param param
     * @return
     */
    Pager<T> find(String sql, String countSql, int pageIndex,int pageSize, Map<String,Object> param);

    /**
     * 基于hsql的连接查询
     * @param hsql
     * @param countSql
     * @param pageIndex
     * @param pageSize
     * @param param
     * @return
     */
    Pager<T> findHsql(String hsql, String countSql, int pageIndex,int pageSize, Map<String,Object> param);
}
