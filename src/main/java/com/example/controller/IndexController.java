package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class IndexController {
    @RequestMapping("/pictrue")
    public String index3(){
        return  "index";
    }
    //单图片上传
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(HttpServletRequest request, MultipartFile file){
        try{
            //上传目录地址
            String uploadDir=request.getSession().getServletContext().getRealPath("/")+"upload/";
            //判断目录是否存在，如果不存在则构建目录
            File dir=new File(uploadDir);
            if(!dir.mkdir()){
                dir.mkdir();
            }
            //文件名后缀
            String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //上传文件名
            String fileName= UUID.randomUUID()+suffix;
            //服务端保存的文件对象
            File saveFile=new File(uploadDir+fileName);
            //将上传的文件写入到服务器端文件内
            file.transferTo(saveFile);
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }
    //提取上传图片的公共方法
    /*
     * uploadDir 上传目录
     * file上传对象
     * */
    public  void  executeUpload(String uploadDir,MultipartFile file) throws IOException {
        //文件名后缀
        String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String fileName=UUID.randomUUID()+suffix;
        //服务端保存文件对象
        File saveFile=new File(uploadDir+fileName);
        //将上传的文件写入到服务器端文件内
        file.transferTo(saveFile);
    }
    //多文件上传
    @RequestMapping("/uploadArray")
    @ResponseBody
    public String uploadArray(HttpServletRequest request,MultipartFile[] file){
        try {
            //上传目录地址
            String uploadDir=request.getSession().getServletContext().getRealPath("/")+"upload/";
            //如果目录不存在，则构建目录
            File dir=new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for(int i=0;i<file.length;i++){
                if(file[i]!=null){
                    //调用上传的方法
                    executeUpload(uploadDir,file[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }
}
