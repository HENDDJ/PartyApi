package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.SysLoginLog;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 登录日志 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysLoginLogServiceTest {

    /** 登录日志 service */
    @Autowired
    private SysLoginLogService sysLoginLogService;

    @Test
    public void saveTest() {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog = sysLoginLogService.save(sysLoginLog);
        assertNotNull(sysLoginLog.getId());
    }

}