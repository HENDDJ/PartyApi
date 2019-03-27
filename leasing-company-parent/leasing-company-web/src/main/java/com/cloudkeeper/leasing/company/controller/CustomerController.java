package com.cloudkeeper.leasing.company.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.dto.customer.CustomerDTO;
import com.cloudkeeper.leasing.company.dto.customer.CustomerSearchable;
import com.cloudkeeper.leasing.company.vo.CustomerVO;
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
 * 客户 controller
 * @author jerry
 */
@Api(value = "客户", tags = "客户")
@RequestMapping("/customer")
public interface CustomerController {

    @ApiOperation(value = "查询客户", notes = "查询客户", position = 1)
    @GetMapping("/{id}id")
//    @Authorization(required = false)
    Result<CustomerVO> findOne(@ApiParam(value = "客户id", required = true) @PathVariable String id);

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<CustomerVO> add(@ApiParam(value = "客户dto", required = true) @RequestBody @Validated CustomerDTO customerDTO);

    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<CustomerVO> update(@ApiParam(value = "客户id", required = true) @PathVariable String id,
                              @ApiParam(value = "客户dto", required = true) @RequestBody @Validated CustomerDTO customerDTO);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "客户id", required = true) @PathVariable String id);

    @ApiOperation(value = "列表查询", notes = "列表查询<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 5)
    @PostMapping("/list")
    Result<List<CustomerVO>> list(@ApiParam(value = "客户查询条件", required = true) @RequestBody CustomerSearchable customerSearchable,
                                  @ApiParam(value = "排序条件", required = true) Sort sort);

    /**
     * 分页查询条件格式
     * api/customer/page?page=0&size=10&sort=code,desc&sort=name,desc
     * 分页参数：
     * page：第几页，默认为0，是第一页
     * size：分页大小，默认为20，在配置文件可以修改spring.data.controller.pageable.default-page-size
     * sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc
     */
    @ApiOperation(value = "分页查询", notes = "分页查询<br/>page：第几页，默认为0，是第一页<br/>size：分页大小, 默认为10<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 6)
    @PostMapping("/page")
    Result<Page<CustomerVO>> page(@ApiParam(value = "客户查询条件", required = true) @RequestBody CustomerSearchable customerSearchable,
                                  @ApiParam(value = "分页参数", required = true) Pageable pageable);


}
