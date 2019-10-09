package com.wangyang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@Scope("prototype")
public class GradeAction extends ActionSupport implements ModelDriven<Grade>{
    Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Resource(name = "gradeService")
    IGradeService gradeService;

    public String find(){
        Pager<Grade> gradePager = gradeService.find("");
        ActionContext.getContext().put("grade",gradePager);
        return SUCCESS;
    }

    public String addInput(){
        return SUCCESS;
    }
    public String add(){
        gradeService.add(grade);
        ActionContext.getContext().put("url","grade_find");
        return "redirect";
    }
    public String updateInput(){
        System.out.println("modelDrive"+grade);
        Grade _grade = gradeService.load(this.grade.getId());
        System.out.println(grade.getId()+"load"+_grade);
        if(grade==null){
            throw new ScheduleException("更新的用户不存在");
        }
        grade=_grade;
        return SUCCESS;
    }
    public String update(){
        gradeService.update(grade);
        ActionContext.getContext().put("url","grade_find");
        return "redirect";
    }
    public String delete(){
        gradeService.delete(grade.getId());
        ActionContext.getContext().put("url","grade_find");
        return "redirect";
    }


    @Override
    public Grade getModel() {
        if(grade==null) grade = new Grade();
        return grade;
    }
}
