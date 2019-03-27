package com.cloudkeeper.leasing.company.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.company.domain.Attendance;
import com.cloudkeeper.leasing.company.repository.AttendanceRepository;
import com.cloudkeeper.leasing.company.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl extends BaseServiceImpl<Attendance> implements AttendanceService {

    /** 出勤Repository*/
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Override
    protected BaseRepository<Attendance> getBaseRepository() {
        return attendanceRepository;
    }
}
