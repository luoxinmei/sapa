package com.sapa.controller;

import com.sapa.common.ResponseCode;
import com.sapa.common.ResponseResult;
import com.sapa.model.Pet;
import com.sapa.req.AddPetReq;
import com.sapa.service.IPetService;
import com.sapa.util.FileUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 罗小妹
 */
@RestController
@Api(tags = {"动物模块"})
@RequestMapping("/pet")
public class PetController {

    @Autowired
    IPetService iPetService;
    @Autowired
    FileUtils fileUtils;

    /**
     *增加动物
     * @param file
     * @param pet
     * @return
     */
    @PostMapping("/add")
    public ResponseResult add(@RequestParam("file") MultipartFile file, AddPetReq pet){
        // 保存图片
        fileUtils.fileSave(file);
        String fileUrl= "http://127.0.0.1/"+file.getOriginalFilename();
        pet.setPicture(fileUrl);
        iPetService.add(pet);
        return ResponseResult.e(ResponseCode.OK);
    }

}

