package com.cloudkeeper.leasing.company.service;

import com.cloudkeeper.leasing.company.domain.Attendance;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AttendanceServiceTest {

    /** 车辆Service*/
    @Autowired
    private AttendanceService attendanceService;

    @Test
    public void saveTest() {
        Attendance attendance = new Attendance();
        attendance.setCause("事由");
        attendance.setDriversId("15740a5c-a551-427f-a9fb-feb1c1d83be2");
        attendance.setVehiclesId("314d6b0d-402a-4631-8f21-20aca1efb461");
        attendance.setEndMileage(123d);
        attendance.setStartMileage(1231d);
        attendanceService.save(attendance);
        System.out.print(attendance);
    }

    @Test
    public void updateTest() {
        Attendance attendance = new Attendance();
        attendance.setId("339ced87-4899-480c-81f6-aa2f2b467ded");
        attendance.setCause("事由333333333");
        attendance.setDriversId("15740a5c-a551-427f-a9fb-feb1c1d83be2");
        attendance.setVehiclesId("314d6b0d-402a-4631-8f21-20aca1efb461");
        attendance.setEndMileage(96633d);
        attendance.setStartMileage(966d);
        attendanceService.save(attendance);
    }
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
}
