package com.cloudkeeper.leasing.company.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.dto.attendance.AttendanceDTO;
import com.cloudkeeper.leasing.company.dto.attendance.AttendanceSearchable;
import com.cloudkeeper.leasing.company.vo.AttendanceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "出勤", tags = "出勤")
@RequestMapping("/attendances")
public interface AttendanceController {

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<AttendanceVO> add(@ApiParam(value = "车辆DTO", required = true) @RequestBody @Validated AttendanceDTO attendanceDTO);

    @ApiOperation(value = "查询", notes = "查询", position = 1)
    @GetMapping("/{id}id")
    Result<AttendanceVO> findOne(@ApiParam(value = "出勤id", required = true) @PathVariable String id);

    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<AttendanceVO> update(@ApiParam(value = "出勤id", required = true) @PathVariable String id,
                              @ApiParam(value = "出勤dto", required = true) @RequestBody @Validated AttendanceDTO attendanceDTO);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "客户id", required = true) @PathVariable String id);

    @ApiOperation(value = "分页查询", notes = "分页查询<br/>page：第几页，默认为0，是第一页<br/>size：分页大小, 默认为10<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 6)
    @PostMapping("/page")
    Result<Page<AttendanceVO>> page(@ApiParam(value = "客户查询条件", required = true) @RequestBody AttendanceSearchable attendanceSearchable,
                                  @ApiParam(value = "分页参数", required = true) Pageable pageable);
}
