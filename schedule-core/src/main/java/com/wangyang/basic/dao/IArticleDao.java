package com.wangyang.basic.dao;

import com.wangyang.model.Article;
import com.wangyang.model.Pager;
import com.wangyang.util.IBaseDao;

public interface IArticleDao extends IBaseDao<Article> {
    /**
     * 根据课程获取教学资源
     * @param couserNameId
     * @param condition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Pager<Article> findByCourseName(int couserNameId,String condition,int pageIndex,int pageSize);

    /**
     * 根据班级获取教学资源
     * @param gradeNameId
     * @param condition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Pager<Article> findByGradeName(int gradeNameId,String condition,int pageIndex,int pageSize);

    /**
     * 根据班级和课程获取教学资源
     * @param courseNameId
     * @param gradeNameId
     * @param condition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Pager<Article> findByGradeNameAndCourseName(int courseNameId,int gradeNameId,String condition,int pageIndex,int pageSize);

}
