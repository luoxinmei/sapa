package com.sapa.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author 罗小妹
 */
@Component
public class FileUtils {
@Value("${file.path}")
private  String filePath;

    /**
     * 保存图片的方法
     * @param file file
     */
    public  void fileSave(MultipartFile file){
        // file对象 文件的路径
        try {
            //保存到 文件夹+ 文件名称
            file.transferTo(new File(filePath+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
