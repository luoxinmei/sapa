package com.sapa.service;

import com.sapa.req.AddAdoptorReq;
import org.springframework.stereotype.Service;


/**
 * @author 罗小妹
 */

public interface IAdoptorService {

    /**
     * 增加申请人
     * @param req
     * @return
     */
    Boolean addAdaptor(AddAdoptorReq req);

}
