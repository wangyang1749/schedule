package com.wangyang.user.service;

import com.wangyang.model.Grade;
import com.wangyang.model.Pager;

public interface IGradeService {

    /**
     * 查找班级分页
     * @param condition
     * @return List
     */
    Pager<Grade> find(String condition);

    /**
     * 查找班级分页
     * @param condition
     * @return String
     */
    String findJson(String condition);

    /**
     * 根据id删除班级
     * @param id
     */
    void delete(int id);

    /**
     * 保存班级
     * @param grade
     */
    void add(Grade grade);

    /**
     * 班级的更新
     * @param grade
     */
    void update(Grade grade);

    /**
     * 查找班级
     * @param id
     * @return
     */
    Grade load(int id);
}
