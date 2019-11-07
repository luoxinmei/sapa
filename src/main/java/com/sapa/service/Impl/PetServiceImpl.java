package com.sapa.service.Impl;

import com.sapa.dao.IPetDao;
import com.sapa.model.Pet;
import com.sapa.req.AddPetReq;
import com.sapa.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 罗小妹
 */
@Service
public class PetServiceImpl implements IPetService {
    @Autowired
    IPetDao iPetDao;
    @Override
    public void add(AddPetReq pet) {
      iPetDao.add(pet);

    }
}
