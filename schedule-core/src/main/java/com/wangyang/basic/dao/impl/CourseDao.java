package com.wangyang.basic.dao.impl;

import com.wangyang.basic.dao.ICourseDao;
import com.wangyang.model.Course;
import com.wangyang.util.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("courseDao")
public class CourseDao extends BaseDao<Course> implements ICourseDao {
    @Override
    public List<Course> findByGradeId(int gradeId) {
        List<Course> courses = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("classNameId",gradeId);
        List<Object[]> list = super.findStr("select distinct  courseName,courseNameId from Schedule where classNameId=:classNameId", map);
        for(Object[] obj:list){
            Course course = new Course();
            course.setCourseName((String) obj[0]);
            course.setCourseNameId((int) obj[1]);
            courses.add(course);
        }
        return courses;
    }
}
