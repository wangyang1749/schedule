package com.wangyang.user.service;

import com.wangyang.basic.dao.IGradeDao;
import com.wangyang.model.Grade;
import com.wangyang.model.Pager;
import com.wangyang.util.SystemContext;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("gradeService")
public class GradeService implements IGradeService {

    @Resource(name = "gradeDao")
    IGradeDao gradeDao;


    @Override
    public Pager<Grade> find(String condition) {
        String sql1="select * from t_grade ORDER BY id desc";
        String sql2="select count(*) from t_grade";
        int pageIndex= SystemContext.getPageIndex();
        int pageSize = SystemContext.getPageSize();
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("week",week);
//        map.put("classtime",classTime);

        Pager<Grade> gradePager = gradeDao.find(sql1, sql2, pageIndex, pageSize, null);
        return gradePager;
    }

    @Override
    public String findJson(String condition) {
        return JSONObject.fromObject(find(condition)).toString();
    }

    @Override
    public void delete(int id) {
        gradeDao.delete(id);
    }

    @Override
    public void add(Grade grade) {
        gradeDao.add(grade);
    }

    @Override
    public void update(Grade grade) {
        gradeDao.update(grade);
    }

    @Override
    public Grade load(int id) {

        return gradeDao.load(id);
    }
}
