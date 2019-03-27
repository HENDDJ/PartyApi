package com.cloudkeeper.leasing.company.service;

import com.cloudkeeper.leasing.company.domain.CommonCompany;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 客户、担保公司、供应商父表 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CommonCompanyServiceTest {

    /** 客户、担保公司、供应商父表 service */
    @Autowired
    private CommonCompanyService commonCompanyService;

    @Test
    public void saveTest() {
        CommonCompany commonCompany = new CommonCompany();
        commonCompany = commonCompanyService.save(commonCompany);
        assertNotNull(commonCompany.getId());
    }

}