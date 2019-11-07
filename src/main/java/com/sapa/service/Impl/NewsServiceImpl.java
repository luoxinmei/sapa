package com.sapa.service.Impl;

import com.sapa.dao.INewsDao;
import com.sapa.req.AddNewsReq;
import com.sapa.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    INewsDao newsDao;

    @Override
    public void addNews(AddNewsReq req) {
        newsDao.addNews(req);

    }
}
