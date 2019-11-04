package com.sapa.dao;

import com.sapa.model.Pet;
import com.sapa.req.AddPetReq;
import org.springframework.stereotype.Repository;

/**
 * @author 罗小妹
 */
@Repository
public interface IPetDao {
    /**
     * 添加动物
     * @param pet pet
     */
    void add(AddPetReq pet);
}