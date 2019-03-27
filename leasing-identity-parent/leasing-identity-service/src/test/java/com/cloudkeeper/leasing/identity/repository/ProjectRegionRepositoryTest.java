package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.ProjectRegion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 小区 repository 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjectRegionRepositoryTest {

    /** 小区 repository */
    @Autowired
    private ProjectRegionRepository projectRegionRepository;

    @Test
    public void saveTest() {
        ProjectRegion projectRegion = new ProjectRegion();
        projectRegion = projectRegionRepository.save(projectRegion);
        assertNotNull(projectRegion.getId());
    }

}