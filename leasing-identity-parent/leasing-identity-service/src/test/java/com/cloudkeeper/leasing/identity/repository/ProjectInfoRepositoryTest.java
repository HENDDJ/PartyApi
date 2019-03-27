package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.ProjectInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 工程信息类 repository 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjectInfoRepositoryTest {

    /** 工程信息类 repository */
    @Autowired
    private ProjectInfoRepository projectInfoRepository;

    @Test
    public void saveTest() {
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo = projectInfoRepository.save(projectInfo);
        assertNotNull(projectInfo.getId());
    }

}