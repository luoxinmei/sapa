package com.sapa.dao;

import com.sapa.model.Adoptor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdoptorDao {
    /**
     * 增加领养者
     * @param name
     * @param gender
     * @param idCard
     * @param telephone
     * @param address
     * @param wechat
     * @param reason
     * @return
     */
    int addAdoptor(@Param("name") String name, @Param("gender") String gender, @Param("idCard") String idCard, @Param("telephone") String telephone, @Param("address") String address, @Param("wechat") String wechat, @Param("reason") String reason);

    int delete(Integer adoptorId);

    /**
     * 根据电话号码查询了领养人
     * @param telephone 电话号码
     * @return Adoptor
     */
    Adoptor findPhone(String telephone);


    /**
     * 查询所有领养者
     * @return
     */
    List<Adoptor> findAll() ;
}