package com.sapa.service;

import com.sapa.model.Pet;
import com.sapa.req.AddPetReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 罗小妹
 */
public interface IPetService {
    /**
     * 添加动物
     *
     * @param pet pet
     */
    void add(AddPetReq pet);

    /**
     *添加宠物领养人ID
     * @param petId
     * @param adoptorId
     */
    void updateAdoptorId(Integer petId,Integer adoptorId);

    /**
     * 修改宠物信息
     * @param
     */
    Boolean update(Pet pet);

    /**
     * 删除动物信息
     * @param petId
     * @return
     */
    Boolean delete(Integer petId);

    /**
     * 查询所有动物
     * @return
     */
    List<Pet> findAll();
}
