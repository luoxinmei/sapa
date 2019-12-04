package com.sapa.service.Impl;

import com.sapa.dao.IUserDao;
import com.sapa.model.User;
import com.sapa.req.UserCheckReq;
import com.sapa.req.UserLoginReq;
import com.sapa.req.UserRegisterReq;
import com.sapa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    @Override
    public User login(UserLoginReq req) {
        List<User> users = userDao.login(req.getTelephone(), req.getPassword());
        return users.size() == 1 ? users.get(0) : null;
    }

    @Override
    public Boolean register(UserRegisterReq req) {
        int i = userDao.insert(req.getUsername(), req.getPassword(), req.getTelephone(), req.getAge(), req.getGender(), req.getWechat());
        return i == 1 ? true : false;
    }

    @Override
    public Boolean checkUser(UserCheckReq req) {
        List<User> users = userDao.checkUser(req.getTelephone());
        //当查询到已存在用户时，返回true；未查询到用户时，返回false

   //     return users.size() == 1 ? true : false;
        //==
        if (users.size() >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean delete(Integer userId) {
        int i=userDao.delete(userId);
        return i==1?true:false;
    }


    @Override
    public Boolean update(User user) {
        int i=userDao.update(user);
        return i==1?true:false;
    }

    @Override
    public List<User> findAll() {
        List<User> users = this.userDao.findAll();
        return users;
    }


}
