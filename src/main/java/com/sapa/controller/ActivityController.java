package com.sapa.controller;


import com.sapa.common.ResponseCode;
import com.sapa.common.ResponseResult;
import com.sapa.model.Activity;
import com.sapa.model.Pet;
import com.sapa.req.AddActivityReq;
import com.sapa.service.IActivityService;
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

/**
 * @author 罗小妹
 */
@RestController
@Api(tags = {"活动模块"})
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    IActivityService activityService;
    @Autowired
    FileUtils fileUtils;

    @PostMapping("/addActivity")
    public ResponseResult addActivity(@RequestParam("file") MultipartFile file, AddActivityReq req) {
        fileUtils.fileSave(file);
        String fileUrl = "http://127.0.0.1/" + file.getOriginalFilename();
        req.setPicture(fileUrl);
        req.setPublishTime(new Date());
        try {
            activityService.addActivity(req);
            return ResponseResult.e(ResponseCode.OK, true);
        } catch (Exception e) {
            return ResponseResult.e(ResponseCode.FAIL, false);
        }
    }

    /**
     * 用户删除
     * @param activityId
     * @return
     */

    @ApiOperation(value = "活动删除", notes = "根据活动id进行删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, paramType = "query", dataType = "int"),
    })

    @PostMapping("/delete")
    @ResponseBody
    public ResponseResult<Boolean> delete(Integer activityId, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResponseResult.e(ResponseCode.OK, activityService.delete(activityId));
    }


    /**
     * 查询所有活动
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询所有活动", notes = "查询所有活动")
    @ResponseBody
    @GetMapping("/findAll")
    public ResponseResult findAll(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Activity> all = activityService.findAll();
        return ResponseResult.e(ResponseCode.OK, all);
    }
}
