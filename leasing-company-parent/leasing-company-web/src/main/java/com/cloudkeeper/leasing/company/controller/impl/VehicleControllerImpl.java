package com.cloudkeeper.leasing.company.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.controller.VehicleController;
import com.cloudkeeper.leasing.company.domain.Vehicle;
import com.cloudkeeper.leasing.company.dto.vehicle.VehicleDTO;
import com.cloudkeeper.leasing.company.dto.vehicle.VehicleSearchable;
import com.cloudkeeper.leasing.company.service.VehicleService;
import com.cloudkeeper.leasing.company.vo.VehicleVO;
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
public class VehicleControllerImpl implements VehicleController {

    /** 车辆 service*/
    @Autowired
    private VehicleService vehicleService;

    @Override
    public Result<VehicleVO> add(@ApiParam(value = "车辆DTO", required = true) @RequestBody @Validated VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleService.save(vehicleDTO.convert(Vehicle.class));
        return Result.ofAddSuccess(vehicle.convert(VehicleVO.class));
    }

    @Override
    public Result<VehicleVO> update(@ApiParam(value = "车辆id", required = true) @PathVariable String id, @ApiParam(value = "车辆DTO", required = true) @RequestBody @Validated VehicleDTO vehicleDTO) {
        Optional<Vehicle> vehicleOptional = vehicleService.findOptionalById(id);
        if (!vehicleOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        Vehicle vehicle = vehicleOptional.get();
        BeanUtils.copyProperties(vehicleDTO, vehicle);
        vehicle = vehicleService.save(vehicle);
        return Result.ofUpdateSuccess(vehicle.convert(VehicleVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "车辆id", required = true) @PathVariable String id) {
        vehicleService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<VehicleVO> findOne(@ApiParam(value = "车辆id", required = true) @PathVariable String id) {
        Optional<Vehicle> vehicleOptional = vehicleService.findOptionalById(id);
        return vehicleOptional.map(vehicle -> Result.of(vehicle.convert(VehicleVO.class))).orElseGet(() -> Result.of("车辆不存在"));
    }

    @Override
    public Result<List<VehicleVO>> list(@ApiParam(value = "用户查询条件", required = true) @RequestBody VehicleSearchable vehicleSearchable,
                                        @ApiParam(value = "排序参数", required = true) Sort sort) {
        List<Vehicle> vehicleList = vehicleService.findAll(vehicleSearchable, sort);
        List<VehicleVO> vehicleVOList = Vehicle.convert(vehicleList, VehicleVO.class);
        return Result.of(vehicleVOList);
    }

    @Override
    public Result<Page<VehicleVO>> page(@ApiParam(value = "用户查询条件", required = true) @RequestBody VehicleSearchable vehicleSearchable,
                                        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Vehicle> vehiclePage = vehicleService.findAll(vehicleSearchable, pageable);
        Page<VehicleVO> vehicleVOPage = Vehicle.convert(vehiclePage, VehicleVO.class);
        return Result.of(vehicleVOPage);
    }
}
