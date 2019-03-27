package com.cloudkeeper.leasing.company.repository;

import com.cloudkeeper.leasing.company.domain.GuaranteeCompany;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 担保公司 repository 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GuaranteeCompanyRepositoryTest {

    /** 担保公司 repository */
    @Autowired
    private GuaranteeCompanyRepository guaranteeCompanyRepository;

    @Test
    public void saveTest() {
        GuaranteeCompany guaranteeCompany = new GuaranteeCompany();
        guaranteeCompany = guaranteeCompanyRepository.save(guaranteeCompany);
        assertNotNull(guaranteeCompany.getId());
    }

}