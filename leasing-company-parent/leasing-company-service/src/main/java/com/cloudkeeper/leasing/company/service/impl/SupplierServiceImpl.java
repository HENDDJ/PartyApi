package com.cloudkeeper.leasing.company.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.company.domain.Supplier;
import com.cloudkeeper.leasing.company.repository.SupplierRepository;
import com.cloudkeeper.leasing.company.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 供应商 service
 * @author asher
 */
@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService {

    /** 供应商 repository */
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    protected BaseRepository<Supplier> getBaseRepository() {
        return supplierRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("category", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}