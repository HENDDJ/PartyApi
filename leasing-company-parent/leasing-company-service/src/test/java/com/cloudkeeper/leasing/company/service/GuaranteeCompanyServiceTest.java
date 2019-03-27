package com.cloudkeeper.leasing.company.service;

import com.cloudkeeper.leasing.company.domain.GuaranteeCompany;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 担保公司 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GuaranteeCompanyServiceTest {

    /** 担保公司 service */
    @Autowired
    private GuaranteeCompanyService guaranteeCompanyService;

    @Test
    public void saveTest() {
        GuaranteeCompany guaranteeCompany = new GuaranteeCompany();
        guaranteeCompany = guaranteeCompanyService.save(guaranteeCompany);
        assertNotNull(guaranteeCompany.getId());
    }

}