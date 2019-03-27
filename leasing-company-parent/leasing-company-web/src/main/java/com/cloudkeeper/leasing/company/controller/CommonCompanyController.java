package com.cloudkeeper.leasing.company.controller;

import com.cloudkeeper.leasing.company.dto.commoncompany.CommonCompanyDTO;
import com.cloudkeeper.leasing.company.dto.commoncompany.CommonCompanySearchable;
import com.cloudkeeper.leasing.company.vo.CommonCompanyVO;
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
 * 客户、担保公司、供应商父表 controller
 * @author asher
 */
@Api(value = "客户、担保公司、供应商父表", tags = "客户、担保公司、供应商父表")
@RequestMapping("/commonCompany")
public interface CommonCompanyController {

    /**
     * 查询
     * @param id 客户、担保公司、供应商父表id
     * @return 客户、担保公司、供应商父表 VO
     */
    @ApiOperation(value = "查询", notes = "查询", position = 1)
    @GetMapping("/{id}id")
    Result<CommonCompanyVO> findOne(@ApiParam(value = "客户、担保公司、供应商父表id", required = true) @PathVariable String id);

    /**
     * 新增
     * @param commonCompanyDTO 客户、担保公司、供应商父表 DTO
     * @return 客户、担保公司、供应商父表 VO
     */
    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<CommonCompanyVO> add(@ApiParam(value = "客户、担保公司、供应商父表 DTO", required = true) @RequestBody @Validated CommonCompanyDTO commonCompanyDTO);

    /**
     * 更新
     * @param id 客户、担保公司、供应商父表id
     * @param commonCompanyDTO 客户、担保公司、供应商父表 DTO
     * @return 客户、担保公司、供应商父表 VO
     */
    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<CommonCompanyVO> update(@ApiParam(value = "客户、担保公司、供应商父表id", required = true) @PathVariable String id,
        @ApiParam(value = "客户、担保公司、供应商父表 DTO", required = true) @RequestBody @Validated CommonCompanyDTO commonCompanyDTO);

    /**
     * 删除
     * @param id 客户、担保公司、供应商父表id
     * @return 删除结果
     */
    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "客户、担保公司、供应商父表id", required = true) @PathVariable String id);

    /**
     * 列表查询
     * @param commonCompanySearchable 客户、担保公司、供应商父表查询条件
     * @param sort 排序条件
     * @return 客户、担保公司、供应商父表 VO 集合
     */
    @ApiOperation(value = "列表查询", notes = "列表查询<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 5)
    @PostMapping("/list")
    Result<List<CommonCompanyVO>> list(@ApiParam(value = "客户、担保公司、供应商父表查询条件", required = true) @RequestBody CommonCompanySearchable commonCompanySearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort);

    /**
     * 分页查询
     * @param commonCompanySearchable 客户、担保公司、供应商父表查询条件
     * @param pageable 分页条件
     * @return 客户、担保公司、供应商父表 VO 分页
     */
    @ApiOperation(value = "分页查询", notes = "分页查询<br/>page：第几页，默认为0，是第一页<br/>size：分页大小, 默认为10<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 6)
    @PostMapping("/page")
    Result<Page<CommonCompanyVO>> page(@ApiParam(value = "客户、担保公司、供应商父表查询条件", required = true) @RequestBody CommonCompanySearchable commonCompanySearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable);

}