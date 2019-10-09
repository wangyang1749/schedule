package com.wangyang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.ModelDriven;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller("classroomAction")
public class ClassroomAction extends ActionSupport implements ModelDriven<Classroom> {
    int week;
    int classtime;
    String condition;
    int id;
    Classroom classroom;

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getClasstime() {
        return classtime;
    }

    public void setClasstime(int classtime) {
        this.classtime = classtime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    IClassroomService classroomService;

    @Resource(name = "classroomService")
    public void setClassroomService(IClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public String emptyClassroom(){
        String emptyClassroom = classroomService.getEmptyClassroomJson(week, classtime, condition);
        ActionContext.getContext().put("emptyClassroom",emptyClassroom);
        return SUCCESS;
    }

    public String find(){
        Pager<Classroom> classroomPager = classroomService.find("");
        ActionContext.getContext().put("classroom",classroomPager);
        return SUCCESS;
    }
    public void findAjax(){

        String classroomPager = classroomService.findJson("");
        PrintWriter writer;
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            writer.print(classroomPager);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ActionContext.getContext().put("classroom",classroomPager);
     //   return SUCCESS;
    }

    public String delete(){
        classroomService.delete(id);
        ActionContext.getContext().put("url","classroom_find");
        return "redirect";
    }

    public String updateInput(){
        return SUCCESS;
    }

    public String update(){
        classroomService.update(classroom);
        ActionContext.getContext().put("url","classroom_find");
        return "redirect";
    }

    public String add(){
        classroomService.add(classroom);
        ActionContext.getContext().put("url","classroom_find");
        return "redirect";
    }
    public String addInput(){
        return SUCCESS;
    }

    @Override
    public Classroom getModel() {
        if(classroom==null)classroom=new Classroom();
        return classroom;
    }
}
