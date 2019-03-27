package com.cloudkeeper.leasing.company.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.company.domain.Customer;
import com.cloudkeeper.leasing.company.repository.CustomerRepository;
import com.cloudkeeper.leasing.company.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 用户 service
 * @author jerry
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {

    /** 用户 repository*/
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    protected BaseRepository<Customer> getBaseRepository() {
        return customerRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("code", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}
