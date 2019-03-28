package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.constant.PropertyConfigurationConstants;
import com.cloudkeeper.leasing.identity.domain.Accessory;
import com.cloudkeeper.leasing.identity.domain.PropertyConfiguration;
import com.cloudkeeper.leasing.identity.dto.accessory.AccessorySearchable;
import com.cloudkeeper.leasing.identity.dto.propertyconfiguration.PropertyConfigurationSearchable;
import com.cloudkeeper.leasing.identity.repository.AccessoryRepository;
import com.cloudkeeper.leasing.identity.service.AccessoryService;
import com.cloudkeeper.leasing.identity.service.FdfsService;
import com.cloudkeeper.leasing.identity.service.PropertyConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 系统附件 service
 * @author asher
 */
@Service
public class AccessoryServiceImpl extends BaseServiceImpl<Accessory> implements AccessoryService {

    /**
     * 系统附件 repository
     */
    @Autowired
    private AccessoryRepository accessoryRepository;

    /** 文件根目录*/
    private static String ROOT_PATH = null;

    /** 系统配置Service*/
    @Autowired
    private PropertyConfigurationService propertyConfigurationService;

    /** 系统配置Service*/
    @Autowired
    @Qualifier("fdfsServiceImpl")
    private FdfsService fdfsServiceImpl;

    @Override
    protected BaseRepository<Accessory> getBaseRepository() {
        return accessoryRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("masterObject", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("description", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("path", ExampleMatcher.GenericPropertyMatchers.contains());
    }

    @Override
    public Accessory save(@Nonnull Accessory entity, MultipartFile multipartFile) throws IOException {
        entity.setName(multipartFile.getOriginalFilename());
        entity.setPath(fdfsServiceImpl.uploadFile(multipartFile));
        return super.save(entity);
    }

    public String getRootPath() {
        if (ROOT_PATH == null) {
            PropertyConfigurationSearchable propertyConfigurationSearchable = new PropertyConfigurationSearchable();
            propertyConfigurationSearchable.setName(PropertyConfigurationConstants.FILE_UPLOAD_PATH);
            Example<PropertyConfiguration> propertyConfigurationExample = propertyConfigurationService.defaultExample(propertyConfigurationSearchable);
            List<PropertyConfiguration> propertyConfigurations = propertyConfigurationService.findAll(propertyConfigurationExample);
            if (!propertyConfigurations.isEmpty()) {
                ROOT_PATH  = propertyConfigurations.get(0).getValue();
            }
        }
        return ROOT_PATH;
    }

    private String getDirPath(Accessory Accessory) {
        return getRootPath()
                + System.getProperty("file.separator") + Accessory.getMasterObject()
                + System.getProperty("file.separator") + Accessory.getMasterTableId()
                + System.getProperty("file.separator") + Accessory.getType();
    }

    private File createDir(Accessory Accessory) {
        File fileDir = new File(getDirPath(Accessory));
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return fileDir;
    }

    private String getFilePath(Accessory Accessory) {
        return getDirPath(Accessory) + System.getProperty("file.separator") + Accessory.getName();
    }

    @Override
    public boolean deleteFile(Accessory accessory) {
        File file = new File(getFilePath(accessory));
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    @Override
    public boolean deleteAndFile(String id) {
        Accessory accessory = super.findById(id);
        fdfsServiceImpl.deleteFile(accessory.getPath());
        super.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAndFile(Accessory accessory) {
        List<Accessory> accessoryList = list(accessory);
        for (Accessory attachments : accessoryList) {
            deleteAndFile(attachments.getId());
        }
        return true;
    }

    @Override
    public Accessory getOne(String masterTableId, String masterObject, String type) {
        Accessory search = new Accessory();
        search.setMasterTableId(masterTableId);
        search.setMasterObject(masterObject);
        search.setType(type);
        List<Accessory> list = list(search);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public void download(Accessory accessory, HttpServletResponse response) throws IOException {
        if (accessory == null) {
            return;
        }
        String filePath = getFilePath(accessory);
        String fileName = accessory.getName();
        download(fileName, filePath, response);
    }

    @Override
    public void download(String fileName, String filePath, HttpServletResponse response) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        download(fileName, new FileInputStream(file), response);
    }

    @Override
    public void download(String fileName, InputStream inputStream, HttpServletResponse response) throws IOException {
        response.reset();
        response.setContentType("multipart/form-data");
        fileName = new String(fileName.getBytes("gb2312"), "ISO8859-1");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            int bytesRead;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private List<Accessory> list(Accessory accessory) {
        Example<Accessory> example= defaultExample(accessory.convert(AccessorySearchable.class));
        return findAll(example);
    }

}
