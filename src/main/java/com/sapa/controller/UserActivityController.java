package com.sapa.controller;

import com.sapa.common.ResponseCode;
import com.sapa.common.ResponseResult;
import com.sapa.req.AddUserActivityReq;
import com.sapa.service.IUserActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 罗小妹
 */
@RestController
@Api(tags = {"用户参加活动模块"})
@RequestMapping("/userActivity")
public class UserActivityController {


    @Autowired
    IUserActivityService userActivityService;

    @ApiOperation(value = "用户参加活动", notes = "根据用户ID和活动ID关联")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, paramType = "query", dataType = "int"),
    })

    /**
     * 用户参加活动
     */
    @PostMapping("/addUserActivity")
    @ResponseBody
    public ResponseResult<Boolean> addUserActivity(AddUserActivityReq req, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResponseResult.e(ResponseCode.OK, userActivityService.addUserActivity(req));
    }
}
