package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.Accessory;
import com.cloudkeeper.leasing.base.service.BaseService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 系统附件 service
 * @author asher
 */
public interface AccessoryService extends BaseService<Accessory> {

    /**
     * 保存文件及记录
     * @param accessory 记录
     * @param multipartFile 文件
     * @return 记录
     */
    Accessory save(@Nonnull Accessory accessory, MultipartFile multipartFile) throws IOException;

    /**
     * 根据记录删除文件
     * @param accessory 记录
     * @return 记录
     */
    boolean deleteFile(Accessory accessory);

    /**
     * 根据记录id删除文件及记录
     * @param id 主键
     * @return boolean
     */
    boolean deleteAndFile(String id);

    /**
     * 根据记录id删除文件及记录
     * @param accessory 记录
     * @return boolean
     */
    boolean deleteAndFile(Accessory accessory);

    /**
     * 根据特定条件查询一条记录
     * @param masterTableId 业务表id
     * @param masterObject 业务表
     * @param type 类型
     * @return
     */
    Accessory getOne(String masterTableId, String masterObject, String type);

    /**
     * 下载文件
     * @param response 业务表id
     * @param  accessory 记录
     * @return
     */
    void download(Accessory accessory, HttpServletResponse response) throws IOException;

    void download(String fileName, String filePath, HttpServletResponse response) throws IOException;

    void download(String fileName, InputStream inputStream, HttpServletResponse response) throws IOException;
}
