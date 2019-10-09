package com.wangyang.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 教师发表的教学资料
 */
@Entity
@Table(name = "t_article")
public class Article {
    private int id;
    /**
     * 文章的标题
     */
    private String title;
    /**
     * 文章的内容
     */
    private String content;
    /**
     * 文章的发布时间
     */
    private Date date;
    /**
     * 文章的发布用户
     */
    private User user;
    /**
     * 文章的发布班级
     */
    private Grade grade;
    /**
     * 文章的课程
     */
    private Course course;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "userid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name = "classnameid")
    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    @ManyToOne
    @JoinColumn(name = "courseid")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
