package com.sapa.service;

import com.sapa.model.Adoptor;
import com.sapa.req.AddAdoptorReq;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 罗小妹
 */

public interface IAdoptorService {

    /**
     * 增加申请人
     *
     * @param req
     * @return
     */
    Boolean addAdaptor(AddAdoptorReq req);

    /**
     * 删除领养者
     * @param adoptorId
     * @return
     */
    Boolean delete(Integer adoptorId);

    /**
     * 查询所有领养者
     * @return
     */
    List<Adoptor> findAll() ;
}
