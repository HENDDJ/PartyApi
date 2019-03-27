package com.cloudkeeper.leasing.company.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.controller.DriverController;
import com.cloudkeeper.leasing.company.domain.Driver;
import com.cloudkeeper.leasing.company.dto.driver.DriverDTO;
import com.cloudkeeper.leasing.company.dto.driver.DriverSearchable;
import com.cloudkeeper.leasing.company.service.DriverService;
import com.cloudkeeper.leasing.company.vo.DriverVO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DriverControllerImpl implements DriverController{

    /** 司机 service*/
    @Autowired
    private DriverService driverService;

    @Override
    public Result<DriverVO> add( @ApiParam(value = "司机dto") @RequestBody @Validated DriverDTO driverDTO) {
        Driver driver = driverService.save(driverDTO.convert(Driver.class));
        return Result.ofAddSuccess(driver.convert(DriverVO.class));
    }

    @Override
    public Result<DriverVO> findOne(@ApiParam(value = "更新id") @PathVariable String id) {
        Optional<Driver> driverOptional = driverService.findOptionalById(id);
        return driverOptional.map(driver -> Result.of(driver.convert(DriverVO.class))).orElseGet(() -> Result.of("用户不存在"));
    }

    @Override
    public Result<DriverVO> update(@ApiParam(value = "更新id") @PathVariable String id, @ApiParam(value = "司机dto") @RequestBody @Validated DriverDTO driverDTO) {
        Optional<Driver> driverOptional = driverService.findOptionalById(id);
        if (!driverOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        Driver driver = driverOptional.get();
        BeanUtils.copyProperties(driverDTO, driver);
        driver = driverService.save(driver);
        return Result.ofUpdateSuccess(driver.convert(DriverVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "删除id") @PathVariable String id) {
        driverService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<DriverVO>> list(@ApiParam(value = "司机查询条件", required = true) @RequestBody DriverSearchable driverSearchable, @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Driver> driverList = driverService.findAll(driverSearchable, sort);
        List<DriverVO> driverVOList = Driver.convert(driverList, DriverVO.class);
        return Result.of(driverVOList);
    }

    @Override
    public Result<Page<DriverVO>> page(@ApiParam(value = "司机查询条件", required = true) @RequestBody DriverSearchable driverSearchable, @ApiParam(value = "分页条件", required = true) Pageable pageable) {
        Page<Driver> driverPage = driverService.findAll(driverSearchable, pageable);
        Page<DriverVO> driverVOPage = Driver.convert(driverPage, DriverVO.class);
        return Result.of(driverVOPage);
    }
}
