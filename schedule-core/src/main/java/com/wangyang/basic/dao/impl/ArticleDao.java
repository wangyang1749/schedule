package com.wangyang.basic.dao.impl;

import com.wangyang.basic.dao.IArticleDao;
import com.wangyang.model.Article;
import com.wangyang.model.Pager;
import com.wangyang.util.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository("articleDao")
public class ArticleDao extends BaseDao<Article> implements IArticleDao {


    @Override
    public Pager<Article> findByCourseName(int couserNameId, String condition, int pageIndex, int pageSize) {
        String sql1 = "select art from Article art join fetch art.user join fetch art.grade join fetch art.course where where art.course.id= :id";
        String sql2 = "select count(*) from t_article where courseid=:id";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", couserNameId);

        Pager<Article> articlePager = super.findHsql(sql1, sql2, pageIndex, pageSize, map);
        return articlePager;
    }

    @Override
    public Pager<Article> findByGradeName(int gradeNameId, String condition, int pageIndex, int pageSize) {
        String sql1 = "select art from Article art join fetch art.user join fetch art.grade join fetch art.course where art.grade.id= :id";
        String sql2 = "select count(*) from t_article where classnameid=:id";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", gradeNameId);

        Pager<Article> articlePager = super.findHsql(sql1, sql2, pageIndex, pageSize, map);
        return articlePager;


    }

    @Override
    public Pager<Article> findByGradeNameAndCourseName(int courseNameId, int gradeNameId, String condition, int pageIndex, int pageSize) {
        String sql1 = "select art from Article art join fetch art.user join fetch art.grade join fetch art.course where  art.grade.id= :id1 and art.course.id= :id2";
        String sql2 = "select count(*) from t_article where classnameid=:id1 and courseid=:id2";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id1", gradeNameId);
        map.put("id2", courseNameId);

        Pager<Article> articlePager = super.findHsql(sql1, sql2, pageIndex, pageSize, map);
        return articlePager;
    }
}