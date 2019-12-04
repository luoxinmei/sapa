package com.sapa.service.Impl;

import com.sapa.dao.IAdoptorDao;
import com.sapa.model.Adoptor;
import com.sapa.model.Pet;
import com.sapa.req.AddAdoptorReq;
import com.sapa.service.IAdoptorService;
import com.sapa.service.IPetService;
import com.sapa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 罗小妹
 */
@Service
@Transactional(rollbackFor = Exception.class)

public class AdoptorServiceImpl implements IAdoptorService {
    @Autowired
    IPetService petService;
    @Autowired
    IAdoptorDao adoptorDao;

    @Override
    public Boolean addAdaptor(AddAdoptorReq req) {
        int i=adoptorDao.addAdoptor(req.getName(),req.getGender(),req.getIdCard(),req.getTelephone(),req.getAddress(),req.getWechat(),req.getReason());
        // 先保存领养人信息
        Adoptor adoptor= adoptorDao.findPhone(req.getTelephone());
        // 更新宠物领养人信息
        petService.updateAdoptorId(req.getPetId(),adoptor.getAdoptorId());
        return i==1?true:false;
    }

    @Override
    public Boolean delete(Integer adoptorId) {
        int i = adoptorDao.delete(adoptorId);
        return i==1?true:false;
    }

    @Override
    public List<Adoptor> findAll() {
        List<Adoptor> adoptors= adoptorDao.findAll();
        return adoptors;
    }
}
