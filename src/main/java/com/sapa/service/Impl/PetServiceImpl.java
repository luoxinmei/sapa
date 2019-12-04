package com.sapa.service.Impl;

import com.sapa.dao.IPetDao;
import com.sapa.model.News;
import com.sapa.model.Pet;
import com.sapa.req.AddPetReq;
import com.sapa.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author 罗小妹
 */

@Service
public class PetServiceImpl implements IPetService {
    @Autowired
    IPetDao iPetDao;

    @Value("${file.path}")
    private  String filePath;
    @Override
    public void add(AddPetReq pet) {
      iPetDao.add(pet);

    }

    @Override
    public void updateAdoptorId(Integer petId, Integer adoptorId) {
        iPetDao.updateAdoptorId(petId,adoptorId);
    }


    @Override
    public Boolean update(Pet pet) {
        int i=iPetDao.update(pet);
        return i==1?true:false;
    }

    @Override
    public Boolean delete(Integer petId) {
        Pet pet =iPetDao.findPet(petId);
        String picture = pet.getPicture();
        //  http://127.0.0.1/IMG_0460.JPG 截取文件名称
        File file=new File(filePath+picture.split("/")[3]);
        if(file.exists()){
            file.delete();
        }
        int i=iPetDao.delete(petId);
        return i==1?true:false;
    }

    @Override
    public List<Pet> findAll() {
        List<Pet> pets = this.iPetDao.findAll();
        return pets;
    }
}
