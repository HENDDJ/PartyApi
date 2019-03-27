package com.cloudkeeper.leasing.company.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.controller.AttendanceController;
import com.cloudkeeper.leasing.company.domain.Attendance;
import com.cloudkeeper.leasing.company.dto.attendance.AttendanceDTO;
import com.cloudkeeper.leasing.company.dto.attendance.AttendanceSearchable;
import com.cloudkeeper.leasing.company.service.AttendanceService;
import com.cloudkeeper.leasing.company.vo.AttendanceVO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AttendanceControllerImpl implements AttendanceController {

    /** 出勤Service*/
    @Autowired
    private AttendanceService attendanceService;

    @Override
    public Result<AttendanceVO> add(@ApiParam(value = "出勤dto") @RequestBody @Validated AttendanceDTO attendanceDTO) {
        Attendance attendance = attendanceService.save(attendanceDTO.convert(Attendance.class));
        return Result.ofAddSuccess(attendance.convert(AttendanceVO.class));
    }

    @Override
    public Result<AttendanceVO> findOne(@ApiParam(value = "出勤id") @PathVariable String id) {
        Optional<Attendance> attendanceOptional = attendanceService.findOptionalById(id);
        return attendanceOptional.map(attendance -> Result.of(attendance.convert(AttendanceVO.class))).orElseGet(() -> Result.of("出勤记录不存在"));
    }

    @Override
    public Result<AttendanceVO> update(@ApiParam(value = "出勤id") @PathVariable String id,@ApiParam(value = "出勤dto") @RequestBody @Validated AttendanceDTO attendanceDTO) {
        Optional<Attendance> attendanceOptional = attendanceService.findOptionalById(id);
        if (!attendanceOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        Attendance attendance = attendanceOptional.get();
        BeanUtils.copyProperties(attendanceDTO, attendance);
        attendance = attendanceService.save(attendance);
        return Result.ofUpdateSuccess(attendance.convert(AttendanceVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "出勤id") @PathVariable String id) {
        attendanceService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<Page<AttendanceVO>> page(@ApiParam(value = "出勤查询条件", required = true) @RequestBody AttendanceSearchable attendanceSearchable, @ApiParam(value = "排序条件", required = true) Pageable pageable) {
        Page<Attendance> attendancePage = attendanceService.findAll(attendanceSearchable, pageable);
        Page<AttendanceVO> attendanceVOPage = Attendance.convert(attendancePage, AttendanceVO.class);
        return Result.of(attendanceVOPage);
    }
}
