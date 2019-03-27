package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.Camera;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 监控 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CameraServiceTest {

    /** 监控 service */
    @Autowired
    private CameraService cameraService;

    @Test
    public void saveTest() {
        Camera camera = new Camera();
        camera = cameraService.save(camera);
        assertNotNull(camera.getId());
    }

}