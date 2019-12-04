package com.sapa.controller;

import com.sapa.common.ResponseCode;
import com.sapa.common.ResponseResult;
import com.sapa.model.User;
import com.sapa.req.UserCheckReq;
import com.sapa.req.UserLoginReq;
import com.sapa.req.UserRegisterReq;
import com.sapa.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 罗小妹
 */
@RestController
@Api(tags = {"用户模块"})
@RequestMapping("/user")
//  @CrossOrigin
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 登录方法
     *
     * @param
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "根据用户手机号和密码进行登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "用户手机号", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String"),
    })
    @PostMapping("/login")
    @ResponseBody
    public ResponseResult<User> login(UserLoginReq req, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.login(req);
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (user == null) {
            return ResponseResult.e(ResponseCode.FAIL, null);
        }
        return ResponseResult.e(ResponseCode.OK, user);
    }


    /**
     * 检查用户名是否存在
     *
     * @param req
     * @return
     */

    @ApiOperation(value = "检查用户名是否存在", notes = "检查用户名是否存在")
    @ApiImplicitParam(name = "telephone", value = "手机号", required = true, paramType = "query", dataType = "String")

    @GetMapping("/checkUser")
    @ResponseBody
    public ResponseResult<Boolean> checkUser(UserCheckReq req, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResponseResult.e(ResponseCode.OK, userService.checkUser(req));
    }


    /**
     * 用户注册
     *
     * @param req
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "根据用户和密码和身份证进行注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "telephone", value = "用户手机号", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "gender", value = "性别", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "wechat", value = "微信号", required = true, paramType = "query", dataType = "String"),
    })

    @PostMapping("/register")
    @ResponseBody
    public ResponseResult<Boolean> register(UserRegisterReq req, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResponseResult.e(ResponseCode.OK, userService.register(req));
    }


    /**
     * 用户删除
     * @param userId
     * @return
     */

    @ApiOperation(value = "用户删除", notes = "根据用户id进行删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "int"),
    })

    @PostMapping("/delete")
    @ResponseBody
    public ResponseResult<Boolean> delete(Integer userId, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResponseResult.e(ResponseCode.OK, userService.delete(userId));
    }


    /**
     * 用户修改
     * @param user
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "用户修改", notes = "用户修改")
    @ResponseBody
    @PostMapping("/update")
    public ResponseResult<Boolean> update(User user, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResponseResult.e(ResponseCode.OK, userService.update(user));
    }

    /**
     * 查询所有用户
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @ResponseBody
    @GetMapping("/findAll")
    public ResponseResult findAll() {
        List<User> all = userService.findAll();
        return ResponseResult.e(ResponseCode.OK, all);
    }

}
