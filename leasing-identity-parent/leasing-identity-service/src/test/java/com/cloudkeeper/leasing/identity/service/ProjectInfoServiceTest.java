package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.ProjectInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 工程信息类 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProjectInfoServiceTest {

    /** 工程信息类 service */
    @Autowired
    private ProjectInfoService projectInfoService;

    @Test
    public void saveTest() {
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo = projectInfoService.save(projectInfo);
        assertNotNull(projectInfo.getId());
    }

}