package com.wangyang;

import com.wangyang.basic.dao.ICourseDao;
import com.wangyang.model.Course;
import com.wangyang.model.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("courseService")
public class CourseService implements ICourseService {

    @Resource(name = "courseDao")
    ICourseDao courseDao;
    @Override
    public void add(Course course) {
        courseDao.add(course);
    }

    @Override
    public void delete(int id) {
        courseDao.delete(id);
    }

    @Override
    public List<Course> findByGradeId(int gradeId) {
        List<Course> courses = courseDao.findByGradeId(gradeId);
        return courses;
    }

    @Override
    public Pager<Course> find(String condition) {
        return null;
    }
}
