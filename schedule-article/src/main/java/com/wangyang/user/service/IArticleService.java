package com.wangyang.user.service;

import com.wangyang.model.Article;
import com.wangyang.model.Pager;

public interface IArticleService {

    /**
     * 添加教学资料
     * @param article
     * @param userId
     * @param gradeId
     */
    void add(Article article, int userId, int gradeId, int courseId);

    /**
     * 分页教学资料
     * @param condition
     * @return
     */
    Pager<Article> find(String condition);

    /**
     * 查找对应班级的教学资料并分页
     * @param gradeName
     * @param condition
     * @return
     */
    Pager<Article> find(String gradeName,String condition);
    /**
     * 删除教学资料
     * @param id
     */
    void delete(int id);

    /**
     * 更新教学资料
     * @param article
     */
    void update(Article article);

    /**
     * 教学资源的详细页面
     * @param id
     */
    Article load(int id);

    /**
     * 根据班级Id获取文章
     * @param gradeId
     * @param condition
     * @return
     */
    Pager<Article> findByGradeId(int gradeId,String condition);

    /**
     * 根据班级和课程id获取文章信息
     * @param gradeId
     * @param courseId
     * @param condition
     * @return
     */
   String findByGradeAndCourseId(int gradeId,int courseId,String condition);
}
