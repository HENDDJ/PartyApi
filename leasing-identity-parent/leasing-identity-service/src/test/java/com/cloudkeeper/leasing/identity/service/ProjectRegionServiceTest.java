package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.ProjectRegion;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 小区 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProjectRegionServiceTest {

    /** 小区 service */
    @Autowired
    private ProjectRegionService projectRegionService;

    @Test
    public void saveTest() {
        ProjectRegion projectRegion = new ProjectRegion();
        projectRegion = projectRegionService.save(projectRegion);
        assertNotNull(projectRegion.getId());
    }

}