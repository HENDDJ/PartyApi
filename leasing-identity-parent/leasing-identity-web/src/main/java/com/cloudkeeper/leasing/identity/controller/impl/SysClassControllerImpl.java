package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SysClassController;
import com.cloudkeeper.leasing.identity.domain.SysClass;
import com.cloudkeeper.leasing.identity.dto.sysclass.SysClassDTO;
import com.cloudkeeper.leasing.identity.dto.sysclass.SysClassSearchable;
import com.cloudkeeper.leasing.identity.service.SysClassService;
import com.cloudkeeper.leasing.identity.vo.SysClassVO;
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
 * 系统java类 controller
 * @author asher
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysClassControllerImpl implements SysClassController {

    /** 系统java类 service */
    private final SysClassService sysClassService;

    @Override
    public Result<SysClassVO> findOne(@ApiParam(value = "系统java类id", required = true) @PathVariable String id) {
        Optional<SysClass> sysClassOptional = sysClassService.findOptionalById(id);
        return sysClassOptional.map(sysClass -> Result.of(sysClass.convert(SysClassVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SysClassVO> add(@ApiParam(value = "系统java类 DTO", required = true) @RequestBody @Validated SysClassDTO sysClassDTO) {
        SysClass sysClass = sysClassService.save(sysClassDTO.convert(SysClass.class));
        return Result.ofAddSuccess(sysClass.convert(SysClassVO.class));
    }

    @Override
    public Result<SysClassVO> update(@ApiParam(value = "系统java类id", required = true) @PathVariable String id,
        @ApiParam(value = "系统java类 DTO", required = true) @RequestBody @Validated SysClassDTO sysClassDTO) {
        Optional<SysClass> sysClassOptional = sysClassService.findOptionalById(id);
        if (!sysClassOptional.isPresent()) {
            return Result.ofLost();
        }
        SysClass sysClass = sysClassOptional.get();
        BeanUtils.copyProperties(sysClassDTO, sysClass);
        sysClass = sysClassService.save(sysClass);
        return Result.ofUpdateSuccess(sysClass.convert(SysClassVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "系统java类id", required = true) @PathVariable String id) {
        sysClassService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SysClassVO>> list(@ApiParam(value = "系统java类查询条件", required = true) @RequestBody SysClassSearchable sysClassSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<SysClass> sysClassList = sysClassService.findAll(sysClassSearchable, sort);
        List<SysClassVO> sysClassVOList = SysClass.convert(sysClassList, SysClassVO.class);
        return Result.of(sysClassVOList);
    }

    @Override
    public Result<Page<SysClassVO>> page(@ApiParam(value = "系统java类查询条件", required = true) @RequestBody SysClassSearchable sysClassSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SysClass> sysClassPage = sysClassService.findAll(sysClassSearchable, pageable);
        Page<SysClassVO> sysClassVOPage = SysClass.convert(sysClassPage, SysClassVO.class);
        return Result.of(sysClassVOPage);
    }

}