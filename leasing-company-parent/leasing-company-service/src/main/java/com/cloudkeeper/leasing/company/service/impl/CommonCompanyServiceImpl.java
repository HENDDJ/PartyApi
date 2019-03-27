package com.cloudkeeper.leasing.company.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.company.domain.CommonCompany;
import com.cloudkeeper.leasing.company.repository.CommonCompanyRepository;
import com.cloudkeeper.leasing.company.service.CommonCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 客户、担保公司、供应商父表 service
 * @author asher
 */
@Service
public class CommonCompanyServiceImpl extends BaseServiceImpl<CommonCompany> implements CommonCompanyService {

    /** 客户、担保公司、供应商父表 repository */
    @Autowired
    private CommonCompanyRepository commonCompanyRepository;

    @Override
    protected BaseRepository<CommonCompany> getBaseRepository() {
        return commonCompanyRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}