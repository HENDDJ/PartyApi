package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SysRoutesMetaController;
import com.cloudkeeper.leasing.identity.domain.SysRoutesMeta;
import com.cloudkeeper.leasing.identity.dto.sysroutesmeta.SysRoutesMetaDTO;
import com.cloudkeeper.leasing.identity.dto.sysroutesmeta.SysRoutesMetaSearchable;
import com.cloudkeeper.leasing.identity.service.SysRoutesMetaService;
import com.cloudkeeper.leasing.identity.vo.SysRoutesMetaVO;
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
 * 系统路由meta controller
 * @author asher
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysRoutesMetaControllerImpl implements SysRoutesMetaController {

    /** 系统路由meta service */
    private final SysRoutesMetaService sysRoutesMetaService;

    @Override
    public Result<SysRoutesMetaVO> findOne(@ApiParam(value = "系统路由meta id", required = true) @PathVariable String id) {
        Optional<SysRoutesMeta> sysRoutesMetaOptional = sysRoutesMetaService.findOptionalById(id);
        return sysRoutesMetaOptional.map(sysRoutesMeta -> Result.of(sysRoutesMeta.convert(SysRoutesMetaVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SysRoutesMetaVO> add(@ApiParam(value = "系统路由meta DTO", required = true) @RequestBody @Validated SysRoutesMetaDTO sysRoutesMetaDTO) {
        SysRoutesMeta sysRoutesMeta = sysRoutesMetaService.save(sysRoutesMetaDTO.convert(SysRoutesMeta.class));
        return Result.ofAddSuccess(sysRoutesMeta.convert(SysRoutesMetaVO.class));
    }

    @Override
    public Result<SysRoutesMetaVO> update(@ApiParam(value = "系统路由metaid", required = true) @PathVariable String id,
        @ApiParam(value = "系统路由meta DTO", required = true) @RequestBody @Validated SysRoutesMetaDTO sysRoutesMetaDTO) {
        Optional<SysRoutesMeta> sysRoutesMetaOptional = sysRoutesMetaService.findOptionalById(id);
        if (!sysRoutesMetaOptional.isPresent()) {
            return Result.ofLost();
        }
        SysRoutesMeta sysRoutesMeta = sysRoutesMetaOptional.get();
        BeanUtils.copyProperties(sysRoutesMetaDTO, sysRoutesMeta);
        sysRoutesMeta = sysRoutesMetaService.save(sysRoutesMeta);
        return Result.ofUpdateSuccess(sysRoutesMeta.convert(SysRoutesMetaVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "系统路由metaid", required = true) @PathVariable String id) {
        sysRoutesMetaService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SysRoutesMetaVO>> list(@ApiParam(value = "系统路由meta查询条件", required = true) @RequestBody SysRoutesMetaSearchable sysRoutesMetaSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<SysRoutesMeta> sysRoutesMetaList = sysRoutesMetaService.findAll(sysRoutesMetaSearchable, sort);
        List<SysRoutesMetaVO> sysRoutesMetaVOList = SysRoutesMeta.convert(sysRoutesMetaList, SysRoutesMetaVO.class);
        return Result.of(sysRoutesMetaVOList);
    }

    @Override
    public Result<Page<SysRoutesMetaVO>> page(@ApiParam(value = "系统路由meta查询条件", required = true) @RequestBody SysRoutesMetaSearchable sysRoutesMetaSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SysRoutesMeta> sysRoutesMetaPage = sysRoutesMetaService.findAll(sysRoutesMetaSearchable, pageable);
        Page<SysRoutesMetaVO> sysRoutesMetaVOPage = SysRoutesMeta.convert(sysRoutesMetaPage, SysRoutesMetaVO.class);
        return Result.of(sysRoutesMetaVOPage);
    }

}