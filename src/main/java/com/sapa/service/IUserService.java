package com.sapa.service;

import com.sapa.model.User;
import com.sapa.req.UserCheckReq;
import com.sapa.req.UserLoginReq;
import com.sapa.req.UserRegisterReq;

/**
 * @author 罗小妹
 */
public interface IUserService {
    /**
     * 用户登录
     * @param req

     * @return boolean
     */

    User login(UserLoginReq req);

    /**
     * 用户注册
     *
     * @param req
     * @return
     */
    Boolean register(UserRegisterReq req);

    /**
     * 检查用户是否存在
     *
     * @param   req
     * @return
     */
    Boolean checkUser(UserCheckReq req);

}
