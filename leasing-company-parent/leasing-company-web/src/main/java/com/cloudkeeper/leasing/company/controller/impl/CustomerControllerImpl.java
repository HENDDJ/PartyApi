package com.cloudkeeper.leasing.company.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.controller.CustomerController;
import com.cloudkeeper.leasing.company.domain.Customer;
import com.cloudkeeper.leasing.company.dto.customer.CustomerDTO;
import com.cloudkeeper.leasing.company.dto.customer.CustomerSearchable;
import com.cloudkeeper.leasing.company.manager.PrincipalManager;
import com.cloudkeeper.leasing.company.service.CustomerService;
import com.cloudkeeper.leasing.company.vo.CustomerVO;
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
public class CustomerControllerImpl implements CustomerController {

    /** 用户 service*/
    @Autowired
    private CustomerService customerService;

    /** 用户manager*/
    @Autowired
    private PrincipalManager principalManager;

    @Override
    public Result<CustomerVO> findOne(@ApiParam(value = "用户id", required = true) @PathVariable String id) {
        System.out.println(principalManager.findOne(id));
        customerService.findById(id);
        Optional<Customer> customerOptional = customerService.findOptionalById(id);
        return customerOptional.map(customer -> Result.of(customer.convert(CustomerVO.class))).orElseGet(() -> Result.of("用户不存在"));
    }

    @Override
    public Result<CustomerVO> add(@ApiParam(value = "用户dto", required = true) @RequestBody @Validated CustomerDTO customerDTO) {
        Customer customer = customerService.save(customerDTO.convert(Customer.class));
        return Result.ofAddSuccess(customer.convert(CustomerVO.class));
    }

    @Override
    public Result<CustomerVO> update(@ApiParam(value = "用户id", required = true) @PathVariable String id,
                                     @ApiParam(value = "用户dto", required = true) @RequestBody @Validated CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerService.findOptionalById(id);
        if (!customerOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        Customer customer = customerOptional.get();
        BeanUtils.copyProperties(customerDTO, customer);
        customer = customerService.save(customer);
        return Result.ofUpdateSuccess(customer.convert(CustomerVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "用户id", required = true) @PathVariable String id) {
        customerService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<CustomerVO>> list(@ApiParam(value = "用户查询条件", required = true) @RequestBody CustomerSearchable customerSearchable,
                                         @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Customer> customerList = customerService.findAll(customerSearchable, sort);
        List<CustomerVO> customerVOList = Customer.convert(customerList, CustomerVO.class);
        return Result.of(customerVOList);
    }

    @Override
    public Result<Page<CustomerVO>> page(@ApiParam(value = "用户查询条件", required = true) @RequestBody CustomerSearchable customerSearchable,
                                         @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Customer> customerPage = customerService.findAll(customerSearchable, pageable);
        Page<CustomerVO> customerVOPage = Customer.convert(customerPage, CustomerVO.class);
        return Result.of(customerVOPage);
    }

}
