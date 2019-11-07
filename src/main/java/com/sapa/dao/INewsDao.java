package com.sapa.dao;

import com.sapa.req.AddNewsReq;
import org.springframework.stereotype.Repository;

@Repository
public interface INewsDao {
    /**
     * 增加新闻
     * @param req
     */
    void addNews(AddNewsReq req);
}