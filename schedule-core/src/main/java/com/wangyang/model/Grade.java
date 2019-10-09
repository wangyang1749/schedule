package com.wangyang.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_grade")
public class Grade {
    private int id;
    private String gradeName;
    private String gradeNameId;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeNameId() {
        return gradeNameId;
    }

    public void setGradeNameId(String gradeNameId) {
        this.gradeNameId = gradeNameId;
    }
}
