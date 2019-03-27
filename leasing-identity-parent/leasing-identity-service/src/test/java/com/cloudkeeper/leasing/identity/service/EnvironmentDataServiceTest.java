package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.EnvironmentData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 环境数据类 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EnvironmentDataServiceTest {

    /** 环境数据类 service */
    @Autowired
    private EnvironmentDataService environmentDataService;

    @Test
    public void saveTest() {
        EnvironmentData environmentData = new EnvironmentData();
        environmentData = environmentDataService.save(environmentData);
        assertNotNull(environmentData.getId());
    }

}