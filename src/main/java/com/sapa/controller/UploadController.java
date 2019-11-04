package com.sapa.controller;

import com.sapa.common.ResponseCode;
import com.sapa.common.ResponseResult;
import com.sapa.util.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 罗小妹
 */

@Api(tags = {"文件上传"})
@RestController
@RequestMapping("/file")
public class UploadController {
@Autowired
    FileUtils fileUtils;
    /**
     * @author 罗小妹
     */
    @PostMapping("/upload")
    public ResponseResult upload(MultipartFile file){
        fileUtils.fileSave(file);
        return ResponseResult.e(ResponseCode.OK);
    }
}
