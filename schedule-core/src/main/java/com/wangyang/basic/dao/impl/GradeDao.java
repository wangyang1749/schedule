package com.wangyang.basic.dao.impl;

import com.wangyang.basic.dao.IGradeDao;
import com.wangyang.model.Grade;
import com.wangyang.util.BaseDao;
import org.springframework.stereotype.Repository;

@Repository("gradeDao")
public class GradeDao extends BaseDao<Grade> implements IGradeDao {

}
