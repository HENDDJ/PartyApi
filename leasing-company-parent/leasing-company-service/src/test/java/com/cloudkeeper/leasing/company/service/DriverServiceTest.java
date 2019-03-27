//package com.cloudkeeper.leasing.company.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class DriverServiceTest {
//
//    /** 车辆Service*/
//    @Autowired
//    private VehicleService vehicleService;
//
//    @Test
//    public void saveTest() {
//        Vehicle vehicle = new Vehicle();
//        vehicle.setLicensePlate("123");
//        vehicle.setMaximumPassenger("20");
//        vehicle.setModel("海格");
//        vehicleService.save(vehicle);
//    }
//
//    @Test
//    public void updateTest() {
//        Vehicle vehicle = new Vehicle();
//        vehicle.setId("225e7884-5392-4543-8f38-8f51b1bd3703");
//        vehicle.setLicensePlate("666");
//        vehicle.setMaximumPassenger("20");
//        vehicle.setModel("66");
//        vehicleService.save(vehicle);
//    }
//
//    @Test
//    public void getTest() {
//        vehicleService.getOne("225e7884-5392-4543-8f38-8f51b1bd3703");
//    }
//
//    @Test
//    public void deleteTest() {
//        vehicleService.deleteById("225e7884-5392-4543-8f38-8f51b1bd3703");
//    }
//}
