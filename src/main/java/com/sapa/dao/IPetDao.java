package com.sapa.dao;
import com.sapa.model.Pet;
import com.sapa.req.AddPetReq;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    /**
     *
     * @param petId
     * @param adoptorId
     */
    void updateAdoptorId(@Param("petId") Integer petId, @Param("adoptorId") Integer adoptorId);

    /**
     * 修改宠物信息
     * @param
     * @return
     */
    int update( Pet pet);

    int delete(Integer petId);

    /**
     * 根据id查询宠物
     * @param petId
     * @return
     */
    Pet findPet(Integer petId);

    /**
     * 查询所有动物
     * @return
     */
    List<Pet> findAll();
}