package com.wangyang;

import com.wangyang.model.Schedule;

import java.util.List;

public interface IScheduleService {
    /**
     * 根据班级获取课程信息
     * @return List
     */
    List<Schedule> list(String className);

    /**
     *
     * @param className
     * @return  String
     */
    String listJson(String className);
    /**
     * 获取教师的课表
     * @return List
     */
    List<Schedule> listTeacher(String teacherName);

    /**
     *获取教师的课表
     * @param teacherName
     * @return String
     */
    String listTeacherJson(String teacherName);

    /**
     * 添加课程信息
     * @param schedule
     */
    void add(Schedule schedule);

}
