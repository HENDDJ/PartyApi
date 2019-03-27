package com.cloudkeeper.leasing.company.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.controller.SupplierController;
import com.cloudkeeper.leasing.company.domain.Supplier;
import com.cloudkeeper.leasing.company.dto.supplier.SupplierDTO;
import com.cloudkeeper.leasing.company.dto.supplier.SupplierSearchable;
import com.cloudkeeper.leasing.company.service.SupplierService;
import com.cloudkeeper.leasing.company.vo.SupplierVO;
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

/**
 * 供应商 controller
 * @author asher
 */
@RestController
public class SupplierControllerImpl implements SupplierController {

    /** 供应商 service */
    @Autowired
    private SupplierService supplierService;

    @Override
    public Result<SupplierVO> findOne(@ApiParam(value = "供应商id", required = true) @PathVariable String id) {
        Optional<Supplier> supplierOptional = supplierService.findOptionalById(id);
        return supplierOptional.map(supplier -> Result.of(supplier.convert(SupplierVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SupplierVO> add(@ApiParam(value = "供应商 DTO", required = true) @RequestBody @Validated SupplierDTO supplierDTO) {
        Supplier supplier = supplierService.save(supplierDTO.convert(Supplier.class));
        return Result.ofAddSuccess(supplier.convert(SupplierVO.class));
    }

    @Override
    public Result<SupplierVO> update(@ApiParam(value = "供应商id", required = true) @PathVariable String id,
        @ApiParam(value = "供应商 DTO", required = true) @RequestBody @Validated SupplierDTO supplierDTO) {
        Optional<Supplier> supplierOptional = supplierService.findOptionalById(id);
        if (!supplierOptional.isPresent()) {
            return Result.ofLost();
        }
        Supplier supplier = supplierOptional.get();
        BeanUtils.copyProperties(supplierDTO, supplier);
        supplier = supplierService.save(supplier);
        return Result.ofUpdateSuccess(supplier.convert(SupplierVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "供应商id", required = true) @PathVariable String id) {
        supplierService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SupplierVO>> list(@ApiParam(value = "供应商查询条件", required = true) @RequestBody SupplierSearchable supplierSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Supplier> supplierList = supplierService.findAll(supplierSearchable, sort);
        List<SupplierVO> supplierVOList = Supplier.convert(supplierList, SupplierVO.class);
        return Result.of(supplierVOList);
    }

    @Override
    public Result<Page<SupplierVO>> page(@ApiParam(value = "供应商查询条件", required = true) @RequestBody SupplierSearchable supplierSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Supplier> supplierPage = supplierService.findAll(supplierSearchable, pageable);
        Page<SupplierVO> supplierVOPage = Supplier.convert(supplierPage, SupplierVO.class);
        return Result.of(supplierVOPage);
    }

}