package com.sapa.controller;

import com.sapa.common.ResponseCode;
import com.sapa.common.ResponseResult;
import com.sapa.model.Pet;
import com.sapa.req.AddPetReq;
import com.sapa.service.IPetService;
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
import java.util.List;

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



    @PostMapping("/update")
    public ResponseResult update(@RequestParam("file") MultipartFile file, Pet pet) {
        // 保存图片
        fileUtils.fileSave(file);
        String fileUrl = "http://127.0.0.1/" + file.getOriginalFilename();
        pet.setPicture(fileUrl);
        try{
            iPetService.update(pet);
            return ResponseResult.e(ResponseCode.OK,true);
        }
        catch (Exception e){
            return ResponseResult.e(ResponseCode.FAIL,false);
        }
    }


    @ApiOperation(value = "删除动物", notes = "根据动物id进行删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "petId", value = "动物id", required = true, paramType = "query", dataType = "int"),
    })

    @PostMapping("/delete")
    @ResponseBody
    public ResponseResult<Boolean> delete(Integer petId, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
//        return ResponseResult.e(ResponseCode.OK, iPetService.delete(petId));
        try{
           iPetService.delete(petId);
            return ResponseResult.e(ResponseCode.OK,true);
        }
        catch (Exception e){
            return ResponseResult.e(ResponseCode.FAIL,false);
        }
    }

    /**
     * 查询所有动物
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询所有动物", notes = "查询所有动物")
    @ResponseBody
    @GetMapping("/findAll")
    public ResponseResult findAll() {
        List<Pet> all = iPetService.findAll();
        return ResponseResult.e(ResponseCode.OK, all);
    }
}

