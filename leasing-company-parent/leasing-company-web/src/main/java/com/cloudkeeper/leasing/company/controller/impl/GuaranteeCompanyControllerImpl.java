package com.cloudkeeper.leasing.company.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.controller.GuaranteeCompanyController;
import com.cloudkeeper.leasing.company.domain.GuaranteeCompany;
import com.cloudkeeper.leasing.company.dto.guaranteecompany.GuaranteeCompanyDTO;
import com.cloudkeeper.leasing.company.dto.guaranteecompany.GuaranteeCompanySearchable;
import com.cloudkeeper.leasing.company.service.GuaranteeCompanyService;
import com.cloudkeeper.leasing.company.vo.GuaranteeCompanyVO;
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
 * 担保公司 controller
 * @author asher
 */
@RestController
public class GuaranteeCompanyControllerImpl implements GuaranteeCompanyController {

    /** 担保公司 service */
    @Autowired
    private GuaranteeCompanyService guaranteeCompanyService;

    @Override
    public Result<GuaranteeCompanyVO> findOne(@ApiParam(value = "担保公司id", required = true) @PathVariable String id) {
        Optional<GuaranteeCompany> guaranteeCompanyOptional = guaranteeCompanyService.findOptionalById(id);
        return guaranteeCompanyOptional.map(guaranteeCompany -> Result.of(guaranteeCompany.convert(GuaranteeCompanyVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<GuaranteeCompanyVO> add(@ApiParam(value = "担保公司 DTO", required = true) @RequestBody @Validated GuaranteeCompanyDTO guaranteeCompanyDTO) {
        GuaranteeCompany guaranteeCompany = guaranteeCompanyService.save(guaranteeCompanyDTO.convert(GuaranteeCompany.class));
        return Result.ofAddSuccess(guaranteeCompany.convert(GuaranteeCompanyVO.class));
    }

    @Override
    public Result<GuaranteeCompanyVO> update(@ApiParam(value = "担保公司id", required = true) @PathVariable String id,
        @ApiParam(value = "担保公司 DTO", required = true) @RequestBody @Validated GuaranteeCompanyDTO guaranteeCompanyDTO) {
        Optional<GuaranteeCompany> guaranteeCompanyOptional = guaranteeCompanyService.findOptionalById(id);
        if (!guaranteeCompanyOptional.isPresent()) {
            return Result.ofLost();
        }
        GuaranteeCompany guaranteeCompany = guaranteeCompanyOptional.get();
        BeanUtils.copyProperties(guaranteeCompanyDTO, guaranteeCompany);
        guaranteeCompany = guaranteeCompanyService.save(guaranteeCompany);
        return Result.ofUpdateSuccess(guaranteeCompany.convert(GuaranteeCompanyVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "担保公司id", required = true) @PathVariable String id) {
        guaranteeCompanyService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<GuaranteeCompanyVO>> list(@ApiParam(value = "担保公司查询条件", required = true) @RequestBody GuaranteeCompanySearchable guaranteeCompanySearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<GuaranteeCompany> guaranteeCompanyList = guaranteeCompanyService.findAll(guaranteeCompanySearchable, sort);
        List<GuaranteeCompanyVO> guaranteeCompanyVOList = GuaranteeCompany.convert(guaranteeCompanyList, GuaranteeCompanyVO.class);
        return Result.of(guaranteeCompanyVOList);
    }

    @Override
    public Result<Page<GuaranteeCompanyVO>> page(@ApiParam(value = "担保公司查询条件", required = true) @RequestBody GuaranteeCompanySearchable guaranteeCompanySearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<GuaranteeCompany> guaranteeCompanyPage = guaranteeCompanyService.findAll(guaranteeCompanySearchable, pageable);
        Page<GuaranteeCompanyVO> guaranteeCompanyVOPage = GuaranteeCompany.convert(guaranteeCompanyPage, GuaranteeCompanyVO.class);
        return Result.of(guaranteeCompanyVOPage);
    }

}