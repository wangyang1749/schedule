package com.wangyang.user.service;

import com.wangyang.basic.dao.IArticleDao;
import com.wangyang.basic.dao.ICourseDao;
import com.wangyang.basic.dao.IGradeDao;
import com.wangyang.basic.dao.IUserDao;
import com.wangyang.model.*;
import com.wangyang.util.SystemContext;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("articleService")
public class ArticleService implements IArticleService {

    @Resource(name = "articleDao")
    IArticleDao articleDao;
    @Resource(name = "userDao")
    IUserDao userDao;
    @Resource(name = "gradeDao")
    IGradeDao gradeDao;

    @Resource(name = "courseDao")
    ICourseDao courseDao;
    @Override
    public void add(Article article, int userId, int gradeId, int courseId) {
        User user = userDao.load(userId);
        Grade grade = gradeDao.load(gradeId);
        Course course = courseDao.load(courseId);
        article.setUser(user);
        article.setGrade(grade);
        article.setCourse(course);
        articleDao.add(article);
    }

    @Override
    public Pager<Article> find(String condition) {
        String sql1 = "select art from Article art join fetch art.user join fetch art.grade join fetch art.course" ;
        String sql2 = "select count(*) from t_article";
        int pageIndex = SystemContext.getPageIndex();
        int pageSize = SystemContext.getPageSize();
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("week",week);
//        map.put("classtime",classTime);

        Pager<Article> articlePager =articleDao.findHsql(sql1, sql2, pageIndex, pageSize, null);
        return articlePager;
    }

    @Override
    public Pager<Article> find(String gradeName, String condition) {
        return null;
    }

    @Override
    public void delete(int id) {
        articleDao.delete(id);
    }

    @Override
    public void update(Article article) {
        articleDao.update(article);
    }

    @Override
    public Article load(int id) {
        return  articleDao.load(id);
    }

    @Override
    public Pager<Article> findByGradeId(int gradeId, String condition) {
        int pageIndex = SystemContext.getPageIndex();
        int pageSize = SystemContext.getPageSize();
        Pager<Article> articlePager = articleDao.findByGradeName(gradeId, condition, pageIndex, pageSize);
        return articlePager;
    }

    @Override
    public String findByGradeAndCourseId(int gradeId, int courseId, String condition) {
        int pageIndex = SystemContext.getPageIndex();
        int pageSize = SystemContext.getPageSize();
        Pager<Article> articlePager = articleDao.findByGradeNameAndCourseName(gradeId,courseId, condition, pageIndex, pageSize);
        JSONObject jsonObject = JSONObject.fromObject(articlePager);
        return jsonObject.toString();
    }
}
