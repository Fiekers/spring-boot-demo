package com.ex.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${spring.http.multipart.location}")
    String filePath = "d:/test"; // 文件上传路径

    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }

            // 获取文件名
            String fileName = file.getOriginalFilename();
            System.out.println("=====>上传的文件名为：" + fileName);

            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("=====>上传的后缀名为：" + suffixName);

            // 解决中文问题，liunx下中文路径，图片显示问题
            fileName = UUID.randomUUID() + suffixName;

            File dest = new File(this.filePath + fileName);


            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.mkdirs();
                dest.getParentFile().mkdirs();
            }

            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("======================>");
            e.printStackTrace();
        }
        return "上传失败";
    }
}