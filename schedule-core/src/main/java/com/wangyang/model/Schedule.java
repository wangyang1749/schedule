package com.wangyang.model;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 课表
 */
@Entity
@DynamicInsert
@Table(name = "t_schedule")
public class Schedule {
    private int id;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 教室名称
     */
    private String classroomName;
    /**
     * 教师姓名
     */
    private String teacherName;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 课程编号
     */
    @Column(name="ISPUBLIC" ,nullable=false,columnDefinition="INT default 0")
    private int courseNameId;
    /**
     * 教室编号
     */
    private int classroomNameId;
    /**
     * 教师编号
     */
    private int teacherNameId;
    /**
     * 班级编号
     */
    private int classNameId;
    /**
     * 星期几上课
     */
    private int week;
    /**
     *第几节课
     */
    private int classTime;
    /**
     * 上课规则
     */
    private String classRule;
    /**
     * 上课的总人数
     */
    private int totalPeople;
    /**
     * 一节课持续的时间
     */
    private int durable;


    @Id
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




    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getCourseNameId() {
        return courseNameId;
    }


    public void setCourseNameId(int courseNameId) {
        this.courseNameId = courseNameId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public int getClassroomNameId() {
        return classroomNameId;
    }

    public void setClassroomNameId(int classroomNameId) {
        this.classroomNameId = classroomNameId;
    }

    public int getTeacherNameId() {
        return teacherNameId;
    }

    public void setTeacherNameId(int teacherNameId) {
        this.teacherNameId = teacherNameId;
    }

    public int getClassNameId() {
        return classNameId;
    }

    public void setClassNameId(int classNameId) {
        this.classNameId = classNameId;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getClassTime() {
        return classTime;
    }

    public void setClassTime(int classTime) {
        this.classTime = classTime;
    }

    public String getClassRule() {
        return classRule;
    }

    public void setClassRule(String classRule) {
        this.classRule = classRule;
    }

    public int getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(int totalPeople) {
        this.totalPeople = totalPeople;
    }

    public int getDurable() {
        return durable;
    }

    public void setDurable(int durable) {
        this.durable = durable;
    }
}