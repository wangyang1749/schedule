package com.wangyang.user.service;

import com.wangyang.model.PagerAjax;
import com.wangyang.basic.dao.IClassroomDao;
import com.wangyang.model.Classroom;
import com.wangyang.model.Pager;
import com.wangyang.util.SystemContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("classroomService")
public class ClassroomService implements IClassroomService {


    IClassroomDao classroomDao;
    @Resource(name = "classroomDao")
    public void setClassroomDao(IClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @Override
    public PagerAjax<Classroom> getEmptyClassroom(int week, int classTime, String condition) {
        String sql ="SELECT * FROM t_classroom WHERE t_classroom.classroomnameid NOT IN " +
                "(SELECT DISTINCT classroomnameid FROM t_schedule  WHERE week = :week AND classtime =:classtime) " ;

        String sql2 ="SELECT count(*) FROM t_classroom WHERE t_classroom.classroomnameid NOT IN " +
                "(SELECT DISTINCT classroomnameid FROM t_schedule  WHERE week = :week AND classtime =:classtime) " ;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("week",week);
        map.put("classtime",classTime);
        int num=SystemContext.getPageIndex();
        PagerAjax<Classroom> pagerAjax = classroomDao.find(sql, sql2, num, map);

        return pagerAjax;
    }

    @Override
    public String getEmptyClassroomJson(int week, int classTime, String condition) {
        JSONArray jsonArray = JSONArray.fromObject(getEmptyClassroom(week, classTime, condition));
        return jsonArray.toString();
    }

    @Override
    public Pager<Classroom> find(String condition) {
        String sql1="select * from t_classroom";
        String sql2="select count(*) from t_classroom";
        int pageIndex= SystemContext.getPageIndex();
        int pageSize = SystemContext.getPageSize();
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("week",week);
//        map.put("classtime",classTime);
        Pager<Classroom> classroomPager = classroomDao.find(sql1, sql2, pageIndex, pageSize, null);
        return classroomPager;
    }

    @Override
    public String findJson(String condition) {
        JSONObject jsonObject = JSONObject.fromObject(find(condition));
        return jsonObject.toString();
    }

    @Override
    public void delete(int id) {
        classroomDao.delete(id);
    }

    @Override
    public void add(Classroom classroom) {
        classroomDao.add(classroom);
    }

    @Override
    public void update(Classroom classroom) {
        classroomDao.update(classroom);
    }
}
