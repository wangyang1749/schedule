package com.wangyang.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 教室信息
 */
@Entity
@Table(name = "t_classroom")
public class Classroom {
    /**
     * 教室名称
     */
    private String classroomName;
    /**
     * 教室描述
     */
    private String describe;
    /**
     * 教室编号
     */
    private int classroomNameId;
    private int id;

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getClassroomNameId() {
        return classroomNameId;
    }

    public void setClassroomNameId(int classroomNameId) {
        this.classroomNameId = classroomNameId;
    }
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
