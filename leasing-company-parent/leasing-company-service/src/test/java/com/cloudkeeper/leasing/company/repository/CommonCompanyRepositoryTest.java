package com.cloudkeeper.leasing.company.repository;

import com.cloudkeeper.leasing.company.domain.CommonCompany;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 客户、担保公司、供应商父表 repository 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommonCompanyRepositoryTest {

    /** 客户、担保公司、供应商父表 repository */
    @Autowired
    private CommonCompanyRepository commonCompanyRepository;

    @Test
    public void saveTest() {
        CommonCompany commonCompany = new CommonCompany();
        commonCompany = commonCompanyRepository.save(commonCompany);
        assertNotNull(commonCompany.getId());
    }

}