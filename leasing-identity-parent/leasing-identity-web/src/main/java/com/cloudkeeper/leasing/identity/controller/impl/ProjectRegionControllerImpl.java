package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.ProjectRegionController;
import com.cloudkeeper.leasing.identity.domain.ProjectRegion;
import com.cloudkeeper.leasing.identity.dto.projectregion.ProjectRegionDTO;
import com.cloudkeeper.leasing.identity.dto.projectregion.ProjectRegionSearchable;
import com.cloudkeeper.leasing.identity.service.ProjectRegionService;
import com.cloudkeeper.leasing.identity.vo.ProjectRegionVO;
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
 * 小区 controller
 * @author asher
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectRegionControllerImpl implements ProjectRegionController {

    /** 小区 service */
    private final ProjectRegionService projectRegionService;

    @Override
    public Result<ProjectRegionVO> findOne(@ApiParam(value = "小区id", required = true) @PathVariable String id) {
        Optional<ProjectRegion> projectRegionOptional = projectRegionService.findOptionalById(id);
        return projectRegionOptional.map(projectRegion -> Result.of(projectRegion.convert(ProjectRegionVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<ProjectRegionVO> add(@ApiParam(value = "小区 DTO", required = true) @RequestBody @Validated ProjectRegionDTO projectRegionDTO) {
        ProjectRegion projectRegion = projectRegionService.save(projectRegionDTO.convert(ProjectRegion.class));
        return Result.ofAddSuccess(projectRegion.convert(ProjectRegionVO.class));
    }

    @Override
    public Result<ProjectRegionVO> update(@ApiParam(value = "小区id", required = true) @PathVariable String id,
        @ApiParam(value = "小区 DTO", required = true) @RequestBody @Validated ProjectRegionDTO projectRegionDTO) {
        Optional<ProjectRegion> projectRegionOptional = projectRegionService.findOptionalById(id);
        if (!projectRegionOptional.isPresent()) {
            return Result.ofLost();
        }
        ProjectRegion projectRegion = projectRegionOptional.get();
        BeanUtils.copyProperties(projectRegionDTO, projectRegion);
        projectRegion = projectRegionService.save(projectRegion);
        return Result.ofUpdateSuccess(projectRegion.convert(ProjectRegionVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "小区id", required = true) @PathVariable String id) {
        projectRegionService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<ProjectRegionVO>> list(@ApiParam(value = "小区查询条件", required = true) @RequestBody ProjectRegionSearchable projectRegionSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<ProjectRegion> projectRegionList = projectRegionService.findAll(projectRegionSearchable, sort);
        List<ProjectRegionVO> projectRegionVOList = ProjectRegion.convert(projectRegionList, ProjectRegionVO.class);
        return Result.of(projectRegionVOList);
    }

    @Override
    public Result<Page<ProjectRegionVO>> page(@ApiParam(value = "小区查询条件", required = true) @RequestBody ProjectRegionSearchable projectRegionSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<ProjectRegion> projectRegionPage = projectRegionService.findAll(projectRegionSearchable, pageable);
        Page<ProjectRegionVO> projectRegionVOPage = ProjectRegion.convert(projectRegionPage, ProjectRegionVO.class);
        return Result.of(projectRegionVOPage);
    }

}