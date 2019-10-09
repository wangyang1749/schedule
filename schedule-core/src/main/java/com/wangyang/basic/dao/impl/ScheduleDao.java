package com.wangyang.basic.dao.impl;

import com.wangyang.basic.dao.IScheduleDao;
import com.wangyang.basic.dao.BaseDao;
import com.wangyang.model.Schedule;

import org.springframework.stereotype.Repository;

@Repository("scheduleDao")
public class ScheduleDao extends BaseDao<Schedule> implements IScheduleDao {

}
