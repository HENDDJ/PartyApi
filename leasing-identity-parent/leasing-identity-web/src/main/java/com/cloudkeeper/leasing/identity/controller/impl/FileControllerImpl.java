package com.cloudkeeper.leasing.identity.controller.impl;
import com.cloudkeeper.leasing.identity.service.impl.FdfsServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@Api(tags = "文件")
public class FileControllerImpl {

    @Autowired
    private FdfsServiceImpl fdfsServiceImpl;

    @PostMapping("upload")
    public String upload(MultipartFile file) throws Exception{
        return fdfsServiceImpl.uploadFile(file);
    }
}
