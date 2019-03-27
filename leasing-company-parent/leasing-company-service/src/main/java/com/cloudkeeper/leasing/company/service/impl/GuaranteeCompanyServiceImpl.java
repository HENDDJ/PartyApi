package com.cloudkeeper.leasing.company.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.company.domain.GuaranteeCompany;
import com.cloudkeeper.leasing.company.repository.GuaranteeCompanyRepository;
import com.cloudkeeper.leasing.company.service.GuaranteeCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 担保公司 service
 * @author asher
 */
@Service
public class GuaranteeCompanyServiceImpl extends BaseServiceImpl<GuaranteeCompany> implements GuaranteeCompanyService {

    /** 担保公司 repository */
    @Autowired
    private GuaranteeCompanyRepository guaranteeCompanyRepository;

    @Override
    protected BaseRepository<GuaranteeCompany> getBaseRepository() {
        return guaranteeCompanyRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("bankName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("bankAccount", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}