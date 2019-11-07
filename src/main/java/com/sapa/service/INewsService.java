package com.sapa.service;

import com.sapa.req.AddNewsReq;

public interface INewsService {

    /**
     * 增加新闻
     * @param req
     */
    void addNews(AddNewsReq req);
}
