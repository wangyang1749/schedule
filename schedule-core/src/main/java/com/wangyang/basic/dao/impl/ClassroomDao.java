package com.wangyang.basic.dao.impl;

import com.wangyang.basic.dao.IClassroomDao;
import com.wangyang.model.Classroom;
import com.wangyang.util.BaseDao;
import org.springframework.stereotype.Repository;

@Repository("classroomDao")
public class ClassroomDao extends BaseDao<Classroom>  implements IClassroomDao {

}
