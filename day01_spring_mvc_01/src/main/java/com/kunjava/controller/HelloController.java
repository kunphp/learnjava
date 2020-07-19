package com.kunjava.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        return "success";
    }

    /**
     * 使用model传参
     * @param model
     * @return
     */
    @RequestMapping("/params")
    public String testParams(Model model){
        Map<String,String> map = new HashMap<String,String>();
        map.put("name","kun");
        map.put("address","上海");
        model.addAllAttributes(map);
        return "params";
    }
    @RequestMapping("/forwardorredirect")
    public String testForwardOrRedirect(){
        return "forward:/WEB-INF/pages/success.jsp";
//        return "redirect:/success.jsp";
    }

    @RequestMapping("/ajax")
    @ResponseBody
    public Map testAjax(@RequestBody Map<String,Object> u){
        System.out.println(u.get("name"));
        System.out.println(u.get("age"));
        Map<String,String> map = new HashMap<String, String>();
        map.put("address","上海");
        return map;
    }

    /**
     * 方式一：原始上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/file1")
    public String testFileUpload1(HttpServletRequest request) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println(path);
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item:items){
            if(item.isFormField()){
            }else{
                String filename = item.getName();
                item.write(new File(path,filename));
                item.delete();
            }
        }
        return "success";
    }

    /**
     * springmvc上传
     * @param request
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/file2")
    public String testFileUpload2(HttpServletRequest request,MultipartFile file) throws Exception{
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File files = new File(path);
        if(!files.exists()){
            files.mkdirs();
        }
        String filename = file.getOriginalFilename();
//        byte[] b = filename.getBytes("UTF-8");
        URLEncoder.encode(filename,"UTF-8");
        file.transferTo(new File(path,filename));
        return "success";
    }

    /**
     * 远程上传
     * @param file
     * @return
     * @throws IOException
     */
    public String testFileUpload3(MultipartFile file)throws IOException {
        // 定义上传文件服务器路径
        String path = "http://localhost:9090/uploads/";
        String filename =  file.getOriginalFilename();
        Client client = new Client();
        WebResource webResource = client.resource(path + filename);
        webResource.put(file.getBytes());
        return "success";
    }
}
