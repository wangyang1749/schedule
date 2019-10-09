package com.wangyang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller("courseAction")
public class CourseAction extends ActionSupport implements ModelDriven<Course> {
    int gradeId;

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    Course course;

    @Resource(name = "courseService")
    ICourseService courseService;
    public String findByGradeId(){
        List<Course> courses= courseService.findByGradeId(2);
        ActionContext.getContext().put("course",courses);

        return  SUCCESS;
    }

    @Override
    public Course getModel() {
        if(course!=null)course = new Course();
        return course;
    }
}
