package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SysClassPropertyController;
import com.cloudkeeper.leasing.identity.domain.SysClassProperty;
import com.cloudkeeper.leasing.identity.dto.sysclassproperty.SysClassPropertyDTO;
import com.cloudkeeper.leasing.identity.dto.sysclassproperty.SysClassPropertySearchable;
import com.cloudkeeper.leasing.identity.service.SysClassPropertyService;
import com.cloudkeeper.leasing.identity.vo.SysClassPropertyVO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
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
 * 类属性配置 controller
 * @author asher
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysClassPropertyControllerImpl implements SysClassPropertyController {

    /** 类属性配置 service */
    private final SysClassPropertyService sysClassPropertyService;

    @Override
    public Result<SysClassPropertyVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<SysClassProperty> sysClassPropertyOptional = sysClassPropertyService.findOptionalById(id);
        return sysClassPropertyOptional.map(sysClassProperty -> Result.of(sysClassProperty.convert(SysClassPropertyVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SysClassPropertyVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated SysClassPropertyDTO sysClassPropertyDTO) {
        SysClassProperty sysClassProperty = sysClassPropertyService.save(sysClassPropertyDTO.convert(SysClassProperty.class));
        return Result.ofAddSuccess(sysClassProperty.convert(SysClassPropertyVO.class));
    }

    @Override
    public Result<SysClassPropertyVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated SysClassPropertyDTO sysClassPropertyDTO) {
        Optional<SysClassProperty> sysClassPropertyOptional = sysClassPropertyService.findOptionalById(id);
        if (!sysClassPropertyOptional.isPresent()) {
            return Result.ofLost();
        }
        SysClassProperty sysClassProperty = sysClassPropertyOptional.get();
        BeanUtils.copyProperties(sysClassPropertyDTO, sysClassProperty);
        sysClassProperty = sysClassPropertyService.save(sysClassProperty);
        return Result.ofUpdateSuccess(sysClassProperty.convert(SysClassPropertyVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        sysClassPropertyService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SysClassPropertyVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody SysClassPropertySearchable sysClassPropertySearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<SysClassProperty> sysClassPropertyList = sysClassPropertyService.findAll(sysClassPropertySearchable, sort);
        List<SysClassPropertyVO> sysClassPropertyVOList = SysClassProperty.convert(sysClassPropertyList, SysClassPropertyVO.class);
        return Result.of(sysClassPropertyVOList);
    }

    @Override
    public Result<Page<SysClassPropertyVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody SysClassPropertySearchable sysClassPropertySearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SysClassProperty> sysClassPropertyPage = sysClassPropertyService.findAll(sysClassPropertySearchable, pageable);
        Page<SysClassPropertyVO> sysClassPropertyVOPage = SysClassProperty.convert(sysClassPropertyPage, SysClassPropertyVO.class);
        return Result.of(sysClassPropertyVOPage);
    }

}