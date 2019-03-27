package com.cloudkeeper.leasing.company.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.controller.CommonCompanyController;
import com.cloudkeeper.leasing.company.domain.CommonCompany;
import com.cloudkeeper.leasing.company.dto.commoncompany.CommonCompanyDTO;
import com.cloudkeeper.leasing.company.dto.commoncompany.CommonCompanySearchable;
import com.cloudkeeper.leasing.company.service.CommonCompanyService;
import com.cloudkeeper.leasing.company.vo.CommonCompanyVO;
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
 * 客户、担保公司、供应商父表 controller
 * @author asher
 */
@RestController
public class CommonCompanyControllerImpl implements CommonCompanyController {

    /** 客户、担保公司、供应商父表 service */
    @Autowired
    private CommonCompanyService commonCompanyService;

    @Override
    public Result<CommonCompanyVO> findOne(@ApiParam(value = "客户、担保公司、供应商父表id", required = true) @PathVariable String id) {
        Optional<CommonCompany> commonCompanyOptional = commonCompanyService.findOptionalById(id);
        return commonCompanyOptional.map(commonCompany -> Result.of(commonCompany.convert(CommonCompanyVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<CommonCompanyVO> add(@ApiParam(value = "客户、担保公司、供应商父表 DTO", required = true) @RequestBody @Validated CommonCompanyDTO commonCompanyDTO) {
        CommonCompany commonCompany = commonCompanyService.save(commonCompanyDTO.convert(CommonCompany.class));
        return Result.ofAddSuccess(commonCompany.convert(CommonCompanyVO.class));
    }

    @Override
    public Result<CommonCompanyVO> update(@ApiParam(value = "客户、担保公司、供应商父表id", required = true) @PathVariable String id,
        @ApiParam(value = "客户、担保公司、供应商父表 DTO", required = true) @RequestBody @Validated CommonCompanyDTO commonCompanyDTO) {
        Optional<CommonCompany> commonCompanyOptional = commonCompanyService.findOptionalById(id);
        if (!commonCompanyOptional.isPresent()) {
            return Result.ofLost();
        }
        CommonCompany commonCompany = commonCompanyOptional.get();
        BeanUtils.copyProperties(commonCompanyDTO, commonCompany);
        commonCompany = commonCompanyService.save(commonCompany);
        return Result.ofUpdateSuccess(commonCompany.convert(CommonCompanyVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "客户、担保公司、供应商父表id", required = true) @PathVariable String id) {
        commonCompanyService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<CommonCompanyVO>> list(@ApiParam(value = "客户、担保公司、供应商父表查询条件", required = true) @RequestBody CommonCompanySearchable commonCompanySearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<CommonCompany> commonCompanyList = commonCompanyService.findAll(commonCompanySearchable, sort);
        List<CommonCompanyVO> commonCompanyVOList = CommonCompany.convert(commonCompanyList, CommonCompanyVO.class);
        return Result.of(commonCompanyVOList);
    }

    @Override
    public Result<Page<CommonCompanyVO>> page(@ApiParam(value = "客户、担保公司、供应商父表查询条件", required = true) @RequestBody CommonCompanySearchable commonCompanySearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<CommonCompany> commonCompanyPage = commonCompanyService.findAll(commonCompanySearchable, pageable);
        Page<CommonCompanyVO> commonCompanyVOPage = CommonCompany.convert(commonCompanyPage, CommonCompanyVO.class);
        return Result.of(commonCompanyVOPage);
    }

}