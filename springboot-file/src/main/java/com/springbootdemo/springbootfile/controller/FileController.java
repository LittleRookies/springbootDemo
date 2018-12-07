package com.springbootdemo.springbootfile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class FileController {
    @Value(value = "${file.path}")
    private String path;

    /**
     * 上传
     *
     * @param multipartFiles
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") List<MultipartFile> multipartFiles) throws IOException {
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.isEmpty()) {
                return "空的";
            }
            String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            File file = new File(path + time + "_" + multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);

        }
        return "success";
    }

    /**
     * 下载
     *
     * @param httpServletResponse
     * @param name
     * @return
     */
    @GetMapping(value = "/downloadFile")
    public String down(HttpServletResponse httpServletResponse, String name) {

        File file = new File(path + name);
        if (!file.exists()) {
            return "-1";
        }

        httpServletResponse.reset();
        httpServletResponse.setHeader("Content-Disposition", "attachment;fileName=" + name);

        try {
            InputStream inStream = new FileInputStream(path + name);
            OutputStream os = httpServletResponse.getOutputStream();

            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = inStream.read(buff)) > 0) {
                os.write(buff, 0, len);
            }
            os.flush();
            os.close();


            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "-2";
        }

        return "0";
    }
}

