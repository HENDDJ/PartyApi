package com.cloudkeeper.leasing.company.service;

import com.cloudkeeper.leasing.company.domain.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class VehicleServiceTest {

    /** 车辆Service*/
    @Autowired
    private VehicleService vehicleService;

    @Test
    public void saveTest() {
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate("12113");
        vehicle.setMaximumPassenger(20);
        vehicle.setModel("海格111");
        vehicleService.save(vehicle);
    }

    @Test
    public void updateTest() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId("9dfb672c-216c-4b1b-b919-b027bf3cdb22");
        vehicle.setLicensePlate("666");
        vehicle.setMaximumPassenger(789);
        vehicle.setModel("6ada6");
        vehicleService.save(vehicle);
    }

    @Test
    public void getTest() {
        vehicleService.getOne("225e7884-5392-4543-8f38-8f51b1bd3703");
    }

    @Test
    public void deleteTest() {
        vehicleService.deleteById("225e7884-5392-4543-8f38-8f51b1bd3703");
    }
}
