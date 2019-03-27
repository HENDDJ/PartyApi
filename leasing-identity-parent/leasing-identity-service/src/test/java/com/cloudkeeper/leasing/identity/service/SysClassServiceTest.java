package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.SysClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 系统java类 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysClassServiceTest {

    /** 系统java类 service */
    @Autowired
    private SysClassService sysClassService;

    @Test
    public void saveTest() {
        SysClass sysClass = new SysClass();
        sysClass = sysClassService.save(sysClass);
        assertNotNull(sysClass.getId());
    }

}