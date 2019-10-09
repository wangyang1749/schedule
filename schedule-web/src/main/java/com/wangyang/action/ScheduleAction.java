package com.wangyang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller("scheduleAction")
@Scope("prototype")
public class ScheduleAction extends ActionSupport implements ModelDriven<Schedule> {
    Schedule schedule;


    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public IScheduleService getScheduleService() {
        return scheduleService;
    }

    private IScheduleService scheduleService;
    @Resource(name = "scheduleService")
    public void setScheduleService(IScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    public String function(){
        return SUCCESS;
    }

    public String query(){
        System.out.println(schedule.getClassName());
        String className = schedule.getClassName();
        if(className==null){
            className="生技1702";
        }
        List<Schedule> schedules = scheduleService.list(className);
        ActionContext.getContext().put("schedules",schedules);
        return SUCCESS;
    }
    public String queryJson(){
        System.out.println(schedule.getClassName());
        String className = schedule.getClassName();
        if(className==null){
            className="生技1702";
        }
        String schedules = scheduleService.listJson(className);
        ActionContext.getContext().put("schedules",schedules);
        return SUCCESS;
    }

    public String queryAdmin(){
        System.out.println(schedule.getClassName());
        String className = schedule.getClassName();
        if(className==null){
            className="生技1702";
        }
        String schedules = scheduleService.listJson(className);
        ActionContext.getContext().put("schedules",schedules);
        return SUCCESS;
    }

    public String queryTeacherJson(){
        String teacherName = schedule.getTeacherName();
        if(teacherName==null){
            teacherName="李小玲";
        }
        String schedules = scheduleService.listTeacherJson(teacherName);
        ActionContext.getContext().put("schedules",schedules);
        return SUCCESS;
    }

    /**
     * 添加课程信息
     * @return
     */
    public String add(){
        scheduleService.add(schedule);
        System.out.println("表单提交后跳转"+schedule.getClassName());
        String param = null;
        try {
            param = new String(schedule.getClassName().getBytes("utf-8"), "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ActionContext.getContext().put("url","schedule_queryAdmin?className="+param);
        return "redirect";
    }

    public String addInput(){
        return SUCCESS;
    }

    @Override
    public Schedule getModel() {
        if(schedule==null)schedule = new Schedule();
        return schedule;
    }
}
