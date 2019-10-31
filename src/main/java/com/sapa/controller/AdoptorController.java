package com.sapa.controller;

import com.sapa.common.ResponseCode;
import com.sapa.common.ResponseResult;
import com.sapa.req.AddAdoptorReq;
import com.sapa.service.IAdoptorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗小妹
 */

@RestController
@Api(tags = {"领养者模块"})
@RequestMapping("/adoptor")
public class AdoptorController {


    @Autowired
   IAdoptorService adoptorService;

    /**
     * 增加领养者
     */

    @ApiOperation(value = "领养者", notes = "领养者填写基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "申请人", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "gender", value = "性别", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "idCard", value = "身份证号码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "telephone", value = "手机号", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "address", value = "家庭地址", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "wechat", value = "微信号", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "reason", value = "申请原因", required = true, paramType = "query", dataType = "String"),
    })

    @PostMapping("/addAdoptor")
    @ResponseBody
    public ResponseResult<Boolean> addAdoptor(AddAdoptorReq req) {

        return ResponseResult.e(ResponseCode.OK, adoptorService.addAdaptor(req));
    }


}
