package com.sapa.service.Impl;

import com.sapa.dao.IActivityDao;
import com.sapa.model.Activity;
import com.sapa.req.AddActivityReq;
import com.sapa.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 罗小妹
 */
@Service
public class ActivityServiceImpl implements IActivityService {

    @Autowired
    IActivityDao activityDao;

    @Override
    public void addActivity(AddActivityReq req) {
        activityDao.addActivity(req);
    }

    @Override
    public Boolean delete(Integer activityId) {
         int i=activityDao.delete(activityId);
        return i==1?true:false;
    }

    @Override
    public List<Activity> findAll() {
        List<Activity>  activitys =activityDao.findAll();
        return activitys;
    }


}
