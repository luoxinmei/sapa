package com.sapa.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdoptorDao {
    int addAdoptor(@Param("name") String name, @Param("gender") String gender, @Param("idCard") String idCard, @Param("telephone") String telephone, @Param("address") String address, @Param("wechat") String wechat, @Param("reason") String reason);

}