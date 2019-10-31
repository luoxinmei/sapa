package com.sapa.dao;

import com.sapa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
  /**
   * 用户登录
   * @param telephone
   * @param password
   * @return
   */
  List<User> login(@Param("telephone") String telephone, @Param("password") String password) ;


  /**
   * 用户注册
   * @param username
   * @param password
   * @param telephone
   * @param age
   * @param gender
   * @param wechat
   * @return
   */
  int insert(@Param("username") String username,@Param("password") String password,@Param("telephone") String telephone,@Param("age") Integer age, @Param("gender") String gender, @Param("wechat") String wechat);

  /**
   * 检查用户是否注册
   * @param password
   * @return
   */
  List<User> checkUser(String password);
}