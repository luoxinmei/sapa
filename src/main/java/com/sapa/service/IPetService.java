package com.sapa.service;

import com.sapa.req.AddPetReq;

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
}
