package com.sapa.service;

import com.sapa.model.Activity;
import com.sapa.req.AddActivityReq;

import java.util.List;

public interface IActivityService {

    /**
     * 增加活动
     * @param req
     */
    void addActivity(AddActivityReq req);

    /**
     * 活动删除
     * @param activityId
     * @return
     */
    Boolean delete(Integer activityId);

    /**
     * 查询所有活动
     * @return
     */
    List<Activity> findAll();
}
