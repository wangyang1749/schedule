package com.wangyang;

import com.wangyang.basic.dao.IScheduleDao;
import com.wangyang.model.Schedule;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("scheduleService")
public class ScheduleService implements IScheduleService {
    @Resource(name = "scheduleDao")
    IScheduleDao scheduleDao;


    @Override
    public List<Schedule> list(String className) {
        List<Schedule> schedules = scheduleDao.list("select * from t_schedule WHERE classname like ?", "%"+className+"%");
        return schedules;
    }

    @Override
    public String listJson(String className){
        List<Schedule> schedules = list(className);
        JSONArray jsonArray = JSONArray.fromObject(schedules);
        return jsonArray.toString();

    }

    @Override
    public List<Schedule> listTeacher(String teacherName) {
        List<Schedule> schedules = scheduleDao.list("select * from t_schedule WHERE teacherName like ?", "%"+teacherName+"%");
        return schedules;
    }

    @Override
    public String listTeacherJson(String teacherName) {
        List<Schedule> schedules = listTeacher(teacherName);
        JSONArray jsonArray = JSONArray.fromObject(schedules);
        return jsonArray.toString();
    }

    @Override
    public void add(Schedule schedule) {
        scheduleDao.add(schedule);
    }
}
