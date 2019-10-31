package com.sapa.service.Impl;

import com.sapa.dao.IUserActivityDao;
import com.sapa.req.AddUserActivityReq;

import com.sapa.service.IUserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 罗小妹
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserActivityServiceImpl implements IUserActivityService {
    @Autowired
    IUserActivityDao userActivityDao;


    @Override
    public Boolean addUserActivity(AddUserActivityReq req) {
        int i=userActivityDao.addUserActivity(req.getUserId(),req.getActivityId());
        return i==1?true:false;
    }
}
