package com.sapa.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 罗小妹
 */
@Repository
public interface IUserActivityDao {

    /**
     * 用户参加活动
     * @param userId
     * @param activityId
     * @return
     */
    int addUserActivity(@Param("userId") Integer userId, @Param("activityId") Integer activityId);

}