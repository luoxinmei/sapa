package com.sapa.service.Impl;

import com.sapa.dao.INewsDao;
import com.sapa.model.News;
import com.sapa.req.AddNewsReq;
import com.sapa.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author 罗小妹
 */
@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    INewsDao newsDao;
    /**
     * 从配置文件拿文件路径
     */
    @Value("${file.path}")
    private  String filePath;
    @Override
    public void addNews(AddNewsReq req) {
        newsDao.addNews(req);
    }

    @Override
    public Boolean delete(Integer newsId) {
        News news=newsDao.findNews(newsId) ;
        String picture = news.getPicture();
        //  http://127.0.0.1/IMG_0460.JPG 截取文件名称
        File file=new File(filePath+picture.split("/")[3]);
        if(file.exists()){
            file.delete();
        }
        int i=newsDao.delete(newsId);

        return i==1?true:false;
    }

    @Override
    public List<News> findAll() {
        List<News> news = this.newsDao.findAll();
        return news;
    }

}
