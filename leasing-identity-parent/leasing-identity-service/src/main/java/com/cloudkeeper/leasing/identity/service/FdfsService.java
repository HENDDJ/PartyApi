package com.cloudkeeper.leasing.identity.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FdfsService {

    String uploadFile(MultipartFile file) throws IOException;

    void deleteFile(String fileUrl);
}
