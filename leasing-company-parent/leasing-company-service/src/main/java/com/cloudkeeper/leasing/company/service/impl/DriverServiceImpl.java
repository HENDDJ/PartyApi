package com.cloudkeeper.leasing.company.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.company.domain.Driver;
import com.cloudkeeper.leasing.company.repository.DriverRepository;
import com.cloudkeeper.leasing.company.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl extends BaseServiceImpl<Driver> implements DriverService {

    /** 司机repository*/
    @Autowired
    private DriverRepository driverRepository;

    @Override
    protected BaseRepository<Driver> getBaseRepository() {
        return driverRepository;
    }
}
