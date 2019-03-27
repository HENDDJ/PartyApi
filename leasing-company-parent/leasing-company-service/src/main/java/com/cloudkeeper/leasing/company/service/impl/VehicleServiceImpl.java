package com.cloudkeeper.leasing.company.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.company.domain.Vehicle;
import com.cloudkeeper.leasing.company.repository.VehicleRepository;
import com.cloudkeeper.leasing.company.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl extends BaseServiceImpl<Vehicle> implements VehicleService {

    /** 车辆 repository*/
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    protected BaseRepository<Vehicle> getBaseRepository() {
        return vehicleRepository;
    }

}
