package com.wangyang.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 课程信息
 */
@Entity
@Table(name = "t_course")
public class Course {

    @Id
    private int id;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程编号
     */
    private int courseNameId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseNameId() {
        return courseNameId;
    }

    public void setCourseNameId(int courseNameId) {
        this.courseNameId = courseNameId;
    }
}
