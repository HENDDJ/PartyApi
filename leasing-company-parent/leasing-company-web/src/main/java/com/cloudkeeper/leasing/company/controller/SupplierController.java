package com.cloudkeeper.leasing.company.controller;

import com.cloudkeeper.leasing.company.dto.supplier.SupplierDTO;
import com.cloudkeeper.leasing.company.dto.supplier.SupplierSearchable;
import com.cloudkeeper.leasing.company.vo.SupplierVO;
import com.cloudkeeper.leasing.base.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 供应商 controller
 * @author asher
 */
@Api(value = "供应商", tags = "供应商")
@RequestMapping("/supplier")
public interface SupplierController {

    /**
     * 查询
     * @param id 供应商id
     * @return 供应商 VO
     */
    @ApiOperation(value = "查询", notes = "查询", position = 1)
    @GetMapping("/{id}id")
    Result<SupplierVO> findOne(@ApiParam(value = "供应商id", required = true) @PathVariable String id);

    /**
     * 新增
     * @param supplierDTO 供应商 DTO
     * @return 供应商 VO
     */
    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<SupplierVO> add(@ApiParam(value = "供应商 DTO", required = true) @RequestBody @Validated SupplierDTO supplierDTO);

    /**
     * 更新
     * @param id 供应商id
     * @param supplierDTO 供应商 DTO
     * @return 供应商 VO
     */
    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<SupplierVO> update(@ApiParam(value = "供应商id", required = true) @PathVariable String id,
        @ApiParam(value = "供应商 DTO", required = true) @RequestBody @Validated SupplierDTO supplierDTO);

    /**
     * 删除
     * @param id 供应商id
     * @return 删除结果
     */
    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "供应商id", required = true) @PathVariable String id);

    /**
     * 列表查询
     * @param supplierSearchable 供应商查询条件
     * @param sort 排序条件
     * @return 供应商 VO 集合
     */
    @ApiOperation(value = "列表查询", notes = "列表查询<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 5)
    @PostMapping("/list")
    Result<List<SupplierVO>> list(@ApiParam(value = "供应商查询条件", required = true) @RequestBody SupplierSearchable supplierSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort);

    /**
     * 分页查询
     * @param supplierSearchable 供应商查询条件
     * @param pageable 分页条件
     * @return 供应商 VO 分页
     */
    @ApiOperation(value = "分页查询", notes = "分页查询<br/>page：第几页，默认为0，是第一页<br/>size：分页大小, 默认为10<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 6)
    @PostMapping("/page")
    Result<Page<SupplierVO>> page(@ApiParam(value = "供应商查询条件", required = true) @RequestBody SupplierSearchable supplierSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable);

}