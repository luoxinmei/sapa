package com.sapa.dao;

import com.sapa.model.Activity;
import com.sapa.req.AddActivityReq;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActivityDao {

    /**
     * 增加活动
     * @param req
     */
    void addActivity(AddActivityReq req);

    /**
     * 活动删除
     * @param
     * @return
     */
    int  delete(Integer activityId);

    /**
     * 查询所有活动
     * @return
     */
    List<Activity> findAll();
}