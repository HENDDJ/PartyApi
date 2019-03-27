package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.Accessory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 系统附件 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AccessoryServiceTest {

    /** 系统附件 service */
    @Autowired
    private AccessoryService accessoryService;

    @Test
    public void saveTest() {
        Accessory accessory = new Accessory();
        accessory = accessoryService.save(accessory);
        assertNotNull(accessory.getId());
    }

}