package com.wangyang;

import com.wangyang.model.Course;
import com.wangyang.model.Pager;

import java.util.List;

public interface ICourseService {
    /**
     * 添加课程
     * @param course
     */
    void add(Course course);

    /**
     * 根据id删除课程
     * @param id
     */
    void delete(int id);

    /**
     * 根据班级名称获取课程
     * @param gradeId
     */
    List<Course> findByGradeId(int gradeId);

    /**
     * 分页列表课程
     * @param condition
     * @return
     */
    Pager<Course> find(String condition);
}
