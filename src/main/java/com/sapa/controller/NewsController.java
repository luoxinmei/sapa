package com.sapa.controller;

import com.sapa.common.ResponseCode;
import com.sapa.common.ResponseResult;
import com.sapa.req.AddNewsReq;
import com.sapa.service.INewsService;
import com.sapa.util.FileUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@RestController
@Api(tags = {"新闻模块"})
@RequestMapping("/news")
public class NewsController {

    @Autowired
    INewsService newsService;
    @Autowired
    FileUtils fileUtils;

    @PostMapping("/addNews")
    public ResponseResult  addNews (@RequestParam("file") MultipartFile file, AddNewsReq req) {
        fileUtils.fileSave(file);
        String fileUrl = "http://127.0.0.1/"+file.getOriginalFilename();
        req.setPicture(fileUrl);
        newsService.addNews(req);
        return ResponseResult.e(ResponseCode.OK);
    }
}
