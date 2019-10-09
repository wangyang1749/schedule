package com.wangyang.user.service;

import com.wangyang.model.PagerAjax;
import com.wangyang.model.Classroom;
import com.wangyang.model.Pager;

public interface IClassroomService {

    /**
     * 查询空闲的教室
     * @param week 查询星期几的
     * @param classTime 哪一节可课
     * @param condition 教室名称
     * @return
     */
    PagerAjax<Classroom> getEmptyClassroom(int week, int classTime, String condition);

    /**
     * 获取json格式的空闲教室
     * @param week
     * @param classTime
     * @param condition
     * @return
     */
    String getEmptyClassroomJson(int week, int classTime, String condition);

    /**
     * 查找教室分页
     * @param condition
     * @return List
     */
    Pager<Classroom> find(String condition);

    /**
     * 查找教室分页
     * @param condition
     * @return String
     */
   String findJson(String condition);

    /**
     * 根据id删除教室
     * @param id
     */
   void delete(int id);

    /**
     * 添加教室对象
     * @param classroom
     */
    void add(Classroom classroom);

    /**
     * 更新教室
     * @param classroom
     */
    void update(Classroom classroom);

}
