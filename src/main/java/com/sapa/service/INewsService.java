package com.sapa.service;

import com.sapa.model.News;
import com.sapa.req.AddNewsReq;

import java.util.List;

public interface INewsService {

    /**
     * 增加新闻
     * @param req
     */
    void addNews(AddNewsReq req);

    /**
     * 新闻删除
     * @param newsId
     * @return
     */
    Boolean delete(Integer newsId);

    /**
     * 查询所有新闻
     * @return
     */
    List<News> findAll();
}
