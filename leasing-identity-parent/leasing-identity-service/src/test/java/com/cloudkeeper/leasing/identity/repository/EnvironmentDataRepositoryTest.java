package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.EnvironmentData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 环境数据类 repository 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EnvironmentDataRepositoryTest {

    /** 环境数据类 repository */
    @Autowired
    private EnvironmentDataRepository environmentDataRepository;

    @Test
    public void saveTest() {
        EnvironmentData environmentData = new EnvironmentData();
        environmentData = environmentDataRepository.save(environmentData);
        assertNotNull(environmentData.getId());
    }

}