package com.wangyang.model;

/**
 * 学院、班级
 */
public class Department {
    private int id;
    /**
     * 学院名称
     */
    private String collegeName;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 学院编号
     */
    private int collegeNameId;
    /**
     * 班级编号
     */
    private int classNameId;
    private int collegeid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getCollegeNameId() {
        return collegeNameId;
    }

    public void setCollegeNameId(int collegeNameId) {
        this.collegeNameId = collegeNameId;
    }

    public int getClassNameId() {
        return classNameId;
    }

    public void setClassNameId(int classNameId) {
        this.classNameId = classNameId;
    }

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }
}
