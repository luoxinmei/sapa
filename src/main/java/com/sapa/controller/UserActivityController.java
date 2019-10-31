package com.sapa.controller;

import com.sapa.common.ResponseResult;
import com.sapa.req.AddUserActivityReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"用户参加活动模块"})
@RequestMapping("/userActivity")
public class UserActivityController {

    @ApiOperation(value = "用户参加活动", notes = "根据用户ID和活动ID关联")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, paramType = "query", dataType = "int"),
    })

    @PostMapping("/addUserActivity")
    @ResponseBody
    public ResponseResult<Boolean> addUserActivity(AddUserActivityReq req) {

        return null;
    }

}
