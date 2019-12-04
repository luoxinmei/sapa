package com.sapa.controller;

import com.sapa.common.ResponseCode;
import com.sapa.common.ResponseResult;
import com.sapa.model.News;
import com.sapa.req.AddNewsReq;
import com.sapa.service.INewsService;
import com.sapa.util.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

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
        req.setPublishTime(new Date());
        try{
            newsService.addNews(req);
            return ResponseResult.e(ResponseCode.OK,true);
        }
        catch (Exception e){
            return ResponseResult.e(ResponseCode.FAIL,false);
        }
    }


    @ApiOperation(value = "新闻删除", notes = "根据新闻id进行删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newsId", value = "新闻id", required = true, paramType = "query", dataType = "int"),
    })

    @PostMapping("/delete")
    @ResponseBody
    public ResponseResult<Boolean> delete(Integer newsId, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResponseResult.e(ResponseCode.OK, newsService.delete(newsId));
    }

    /**
     * 查询所有用户
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询所有新闻", notes = "查询所有新闻")
    @ResponseBody
    @GetMapping("/findAll")
    public ResponseResult findAll() {
        List<News> all =newsService.findAll();
        return ResponseResult.e(ResponseCode.OK, all);
    }
}
