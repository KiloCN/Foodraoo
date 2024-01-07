package cn.kilo.foodraoo.cloudstorage.controller;

import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.common.exception.FileRelatedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * CommonController is a REST controller for handling File upload and File download HTTP requests.
 *
 * @version 0.0.1-SNAPSHOT
 * @author kilo
 */

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${foodraoo.img-path}")
    private String imgPath;

    /**
     * File upload
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public Result<String> uploadFile(MultipartFile file){

        String absolutelyPath = Thread.currentThread().getContextClassLoader().getResource("application.yml").getPath();
        absolutelyPath = absolutelyPath.replace("application.yml",imgPath);
        File imgDir = new File(absolutelyPath);
        if(!imgDir.exists()){
            imgDir.mkdirs();
        }


//        String fileSuffix = file.getOriginalFilename().split(".")[1];
        String originalFilename = file.getOriginalFilename();
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString()+fileSuffix;
        try {
            file.transferTo(new File(absolutelyPath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success(fileName);
    }


    /**
     * File download
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void downloadFile(String name, HttpServletResponse response){
        String absolutelyPath = Thread.currentThread().getContextClassLoader().getResource("application.yml").getPath();
        absolutelyPath = absolutelyPath.replace("application.yml",imgPath);

        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(absolutelyPath+name);

            outputStream = response.getOutputStream();

//            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes);
                outputStream.flush();

            }
            fileInputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new FileRelatedException(e.getMessage().toString());
        } catch (IOException e) {
            throw new FileRelatedException(e.getMessage().toString());
        }

    }
}
