package com.wangyang.basic.dao;

import com.wangyang.model.Course;
import com.wangyang.util.IBaseDao;

import java.util.List;

public interface ICourseDao extends IBaseDao<Course> {
    List<Course> findByGradeId(int gradeId);

}
