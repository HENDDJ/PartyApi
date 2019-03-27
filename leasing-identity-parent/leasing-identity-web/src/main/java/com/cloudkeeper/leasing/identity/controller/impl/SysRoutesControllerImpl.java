package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SysRoutesController;
import com.cloudkeeper.leasing.identity.domain.SysRoutes;
import com.cloudkeeper.leasing.identity.dto.sysroutes.SysRoutesDTO;
import com.cloudkeeper.leasing.identity.dto.sysroutes.SysRoutesSearchable;
import com.cloudkeeper.leasing.identity.service.SysRoutesService;
import com.cloudkeeper.leasing.identity.vo.SysRoutesVO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
 * 系统路由 controller
 * @author asher
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysRoutesControllerImpl implements SysRoutesController {

    /** 系统路由 service */
    private final SysRoutesService sysRoutesService;

    @Override
    public Result<SysRoutesVO> findOne(@ApiParam(value = "系统路由id", required = true) @PathVariable String id) {
        Optional<SysRoutes> sysRoutesOptional = sysRoutesService.findOptionalById(id);
        return sysRoutesOptional.map(sysRoutes -> Result.of(sysRoutes.convert(SysRoutesVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SysRoutesVO> add(@ApiParam(value = "系统路由 DTO", required = true) @RequestBody @Validated SysRoutesDTO sysRoutesDTO) {
        SysRoutes sysRoutes = sysRoutesService.save(sysRoutesDTO);
        return Result.ofAddSuccess(sysRoutes.convert(SysRoutesVO.class));
    }

    @Override
    public Result<SysRoutesVO> update(@ApiParam(value = "系统路由id", required = true) @PathVariable String id,
        @ApiParam(value = "系统路由 DTO", required = true) @RequestBody @Validated SysRoutesDTO sysRoutesDTO) {
        Optional<SysRoutes> sysRoutesOptional = sysRoutesService.findOptionalById(id);
        if (!sysRoutesOptional.isPresent()) {
            return Result.ofLost();
        }
        SysRoutes sysRoutes = sysRoutesService.save(sysRoutesDTO);
        return Result.ofUpdateSuccess(sysRoutes.convert(SysRoutesVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "系统路由id", required = true) @PathVariable String id) {
        sysRoutesService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SysRoutesVO>> list(@ApiParam(value = "系统路由查询条件", required = true) @RequestBody SysRoutesSearchable sysRoutesSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SysRoutes.class);
        detachedCriteria.add(Restrictions.isNull("parentId"));
        List<SysRoutes> sysRoutesList = sysRoutesService.findAll(detachedCriteria);
        List<SysRoutesVO> sysRoutesVOList = SysRoutes.convert(sysRoutesList, SysRoutesVO.class);
        return Result.of("菜单加载成功", sysRoutesVOList);
    }

    @Override
    public Result<Page<SysRoutesVO>> page(@ApiParam(value = "系统路由查询条件", required = true) @RequestBody SysRoutesSearchable sysRoutesSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SysRoutes> sysRoutesPage = sysRoutesService.findAll(sysRoutesSearchable, pageable);
        Page<SysRoutesVO> sysRoutesVOPage = SysRoutes.convert(sysRoutesPage, SysRoutesVO.class);
        return Result.of(sysRoutesVOPage);
    }

}