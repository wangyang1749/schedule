package com.wangyang.test;



import com.wangyang.basic.dao.*;
import com.wangyang.core.dao.*;
import com.wangyang.dao.*;
import com.wangyang.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TBaseDao {

    @Resource(name = "userDao")
    IUserDao userDao;

    @Resource(name = "scheduleDao")
    IScheduleDao scheduleDao;

    @Resource(name = "classroomDao")
    IClassroomDao classroomDao;

    @Resource(name = "gradeDao")
    IGradeDao gradeDao;

    @Resource(name = "articleDao")
    IArticleDao articleDao;

    @Resource(name = "courseDao")
    ICourseDao courseDao;
    @Test
    public  void add(){
        User user = new User();
        user.setUsername("悟空");
        userDao.add(user);
    }
    @Test
    public void testList(){
        List<User> list = userDao.list("select * from t_user where id = ?",8);
        for(User user:list){
            System.out.println(user.getUsername());
        }
    }
    @Test
    public void testSchedule(){
        List<Schedule> list = scheduleDao
                .list("select * from t_schedule WHERE classname like ?","%生技1702%");
        for (Schedule schedule:list){
            System.out.println(schedule.getCourseName());
        }
    }

    @Test
    public void testPager(){


        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","%多媒体%");
        PagerAjax<Classroom> pagerAjax = classroomDao.find("select * from t_classroom where classroomname like :name", " select count(*) from t_classroom where  classroomname like :name ",5,map);
        System.out.println(pagerAjax.getDatas().get(1).getClassroomName());
        System.out.println(pagerAjax.getTotalRecord());
    }
    @Test
    public  void emptyClassroom(){
        String sql ="SELECT * FROM t_classroom WHERE t_classroom.classroomnameid NOT IN " +
                "(SELECT DISTINCT classroomnameid FROM t_schedule  WHERE week = :week AND classtime =:classtime) " ;

        String sql2 ="SELECT count(*) FROM t_classroom WHERE t_classroom.classroomnameid NOT IN " +
                "(SELECT DISTINCT classroomnameid FROM t_schedule  WHERE week = :week AND classtime =:classtime) " ;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("week",1);
        map.put("classtime",1);
        PagerAjax<Classroom> classroomPagerAjax = classroomDao.find(sql, sql2, 5, map);
        System.out.println(classroomPagerAjax.getTotalRecord());
    }
    @Test
    public void testAdd(){
        User user = userDao.load(80);
        System.out.println(user);

    }
    @Test
    public void update(){
        User user = new User();

        user.setCollegeName("58956");
        user.setId(1);

        userDao.update(userDao.load(1));
    }

    @Test
    public void load(){
        System.out.println(userDao.load(1));
    }

    @Test
    public void updateGrade(){
        Grade grade = new Grade();
        grade.setId(1);
        grade.setGradeName("abc");
        gradeDao.update(grade);
    }

    @Test
    public void addArticle(){
//        User user =new User();
//        user.setId(3);
        User user = userDao.load(3);
        Article article = new Article();
        article.setUser(user);
//        article.setTitle("1896");
        articleDao.add(article);
    }
    @Test
    public void loadArticle(){
        Article load = articleDao.load(4);
        System.out.println(load.getTitle());
    }
    @Test
    public void findArticle(){
        String sql1 = "select art from Article art join fetch art.user join fetch art.grade where art.grade.id= :id";
        String sql2 = "select count(*) from t_article where classnameid=:id";

        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        Pager<Article> articlePager =articleDao.findHsql(sql1, sql2,1, 5, map);
        System.out.println(articlePager.getData().size());
        System.out.println(articlePager.getTotalRecord());

    }
    @Test
    public void listCourse(){
       courseDao.findByGradeId(0);
    }
}
