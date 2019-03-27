package com.cloudkeeper.leasing.company.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.controller.IntentionalCustomerController;
import com.cloudkeeper.leasing.company.domain.IntentionalCustomer;
import com.cloudkeeper.leasing.company.dto.intentionalCustomer.IntentionalCustomerDTO;
import com.cloudkeeper.leasing.company.dto.intentionalCustomer.IntentionalCustomerSearchable;
import com.cloudkeeper.leasing.company.dto.vehicle.VehicleDTO;
import com.cloudkeeper.leasing.company.dto.vehicle.VehicleSearchable;
import com.cloudkeeper.leasing.company.service.IntentionalCustomerService;
import com.cloudkeeper.leasing.company.vo.IntentionalCustomerVO;
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
public class IntentionalCustomerControllerImpl implements IntentionalCustomerController {

    /** 意向客户Service*/
    @Autowired
    private IntentionalCustomerService intentionalCustomerService;

    @Override
    public Result<IntentionalCustomerVO> add(@ApiParam(value = "意向客户dto") @RequestBody @Validated IntentionalCustomerDTO intentionalCustomerDTO) {
        IntentionalCustomer intentionalCustomer = intentionalCustomerService.save(intentionalCustomerDTO.convert(IntentionalCustomer.class));
        return Result.ofAddSuccess(intentionalCustomer.convert(IntentionalCustomerVO.class));
    }

    @Override
    public Result<IntentionalCustomerVO> update(@ApiParam(value = "意向客户id") @PathVariable String id, @ApiParam(value = "意向客户dto") @RequestBody @Validated IntentionalCustomerDTO intentionalCustomerDTO) {
        Optional<IntentionalCustomer> intentionalCustomerOptional = intentionalCustomerService.findOptionalById(id);
        if (!intentionalCustomerOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        IntentionalCustomer intentionalCustomer = intentionalCustomerOptional.get();
        BeanUtils.copyProperties(intentionalCustomerDTO, intentionalCustomer);
        intentionalCustomer = intentionalCustomerService.save(intentionalCustomer);
        return Result.ofUpdateSuccess(intentionalCustomer.convert(IntentionalCustomerVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "意向客户id") @PathVariable String id) {
        intentionalCustomerService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<IntentionalCustomerVO> findOne(@ApiParam(value = "意向客户id") @PathVariable String id) {
        Optional<IntentionalCustomer> intentionalCustomerOptional = intentionalCustomerService.findOptionalById(id);
        return intentionalCustomerOptional.map(intentionalCustomer -> Result.of(intentionalCustomer.convert(IntentionalCustomerVO.class))).orElseGet(() -> Result.of("意向客户不存在"));
    }

    @Override
    public Result<List<IntentionalCustomerVO>> list(@ApiParam(value = "意向客户查询条件", required = true) @RequestBody IntentionalCustomerSearchable intentionalCustomerSearchable,
                                                    @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<IntentionalCustomer> intentionalCustomers = intentionalCustomerService.findAll(intentionalCustomerSearchable, sort);
        List<IntentionalCustomerVO> intentionalCustomerVOList = IntentionalCustomer.convert(intentionalCustomers, IntentionalCustomerVO.class);
        return Result.of(intentionalCustomerVOList);
    }

    @Override
    public Result<Page<IntentionalCustomerVO>> page(@ApiParam(value = "意向客户查询条件", required = true) @RequestBody IntentionalCustomerSearchable intentionalCustomerSearchable,
                                                    @ApiParam(value = "分页条件", required = true)Pageable pageable) {
        Page<IntentionalCustomer> intentionalCustomerPage = intentionalCustomerService.findAll(intentionalCustomerSearchable, pageable);
        Page<IntentionalCustomerVO> intentionalCustomerVOPage = IntentionalCustomer.convert(intentionalCustomerPage, IntentionalCustomerVO.class);
        return Result.of(intentionalCustomerVOPage);
    }
}
