package com.sapa.service;

import com.sapa.req.AddUserActivityReq;


/**
 * @author 罗小妹
 */
public interface IUserActivityService {
    /**
     * 用户参加活动
     * @param req
     * @return
     */
    Boolean addUserActivity(AddUserActivityReq req);
}
