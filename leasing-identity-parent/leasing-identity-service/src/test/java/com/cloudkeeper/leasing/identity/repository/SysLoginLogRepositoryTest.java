package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.SysLoginLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 登录日志 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SysLoginLogRepositoryTest {

    /** 登录日志 repository */
    @Autowired
    private SysLoginLogRepository sysLoginLogRepository;

    @Test
    public void saveTest() {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog = sysLoginLogRepository.save(sysLoginLog);
        assertNotNull(sysLoginLog.getId());
    }

}