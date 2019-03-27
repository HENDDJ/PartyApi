package com.cloudkeeper.leasing.company.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.dto.intentionalCustomer.IntentionalCustomerDTO;
import com.cloudkeeper.leasing.company.dto.intentionalCustomer.IntentionalCustomerSearchable;
import com.cloudkeeper.leasing.company.dto.vehicle.VehicleDTO;
import com.cloudkeeper.leasing.company.dto.vehicle.VehicleSearchable;
import com.cloudkeeper.leasing.company.vo.IntentionalCustomerVO;
import com.cloudkeeper.leasing.company.vo.VehicleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "意向客户", tags = "意向客户")
@RequestMapping("/intentionalCustomers")
public interface IntentionalCustomerController {

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<IntentionalCustomerVO> add(@ApiParam(value = "意向客户DTO", required = true) @RequestBody @Validated IntentionalCustomerDTO intentionalCustomerDTO);

    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<IntentionalCustomerVO> update(@ApiParam(value = "意向客户id", required = true) @PathVariable String id,
                             @ApiParam(value = "意向客户DTO", required = true) @RequestBody @Validated IntentionalCustomerDTO intentionalCustomerDTO);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "意向客户id", required = true) @PathVariable String id);

    @ApiOperation(value = "查询", notes = "查询", position = 1)
    @GetMapping("/{id}id")
    Result<IntentionalCustomerVO> findOne(@ApiParam(value = "意向客户id", required = true) @PathVariable String id);

    @ApiOperation(value = "列表查询", notes = "列表查询<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 5)
    @PostMapping("/list")
    Result<List<IntentionalCustomerVO>> list(@ApiParam(value = "客户查询条件", required = true) @RequestBody IntentionalCustomerSearchable intentionalCustomerSearchable,
                                             @ApiParam(value = "排序条件", required = true) Sort sort);

    @ApiOperation(value = "分页查询", notes = "分页查询<br/>page：第几页，默认为0，是第一页<br/>size：分页大小, 默认为10<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 6)
    @PostMapping("/page")
    Result<Page<IntentionalCustomerVO>> page(@ApiParam(value = "客户查询条件", required = true) @RequestBody IntentionalCustomerSearchable intentionalCustomerSearchable,
                                 @ApiParam(value = "分页参数", required = true) Pageable pageable);
}
