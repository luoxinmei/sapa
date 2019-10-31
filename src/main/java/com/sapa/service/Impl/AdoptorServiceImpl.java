package com.sapa.service.Impl;

import com.sapa.dao.IAdoptorDao;
import com.sapa.req.AddAdoptorReq;
import com.sapa.service.IAdoptorService;
import com.sapa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 罗小妹
 */
@Service
@Transactional(rollbackFor = Exception.class)

public class AdoptorServiceImpl implements IAdoptorService {

    @Autowired
    IAdoptorDao adoptorDao;

    @Override
    public Boolean addAdaptor(AddAdoptorReq req) {
        int i=adoptorDao.addAdoptor(req.getName(),req.getGender(),req.getIdCard(),req.getTelephone(),req.getAddress(),req.getWechat(),req.getReason());
        return i==1?true:false;
    }
}
