package com.sapa.dao;

import com.sapa.model.News;
import com.sapa.req.AddNewsReq;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INewsDao {
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
    int delete(Integer newsId);

    /**
     * 根据id查询新闻
     * @param newsId
     * @return
     */
    News findNews(Integer newsId);

    /**
     * 查询所有新闻
     * @return
     */
    List<News> findAll();
}