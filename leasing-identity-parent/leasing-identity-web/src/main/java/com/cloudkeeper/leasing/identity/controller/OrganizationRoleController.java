package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.dto.organizationrole.OrganizationRoleDTO;
import com.cloudkeeper.leasing.identity.vo.OrganizationRoleVO;
import com.cloudkeeper.leasing.base.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 组织角色 controller
 * @author jerry
 */
@Api(value = "组织角色", tags = "组织角色")
@RequestMapping("/organizationRole")
public interface OrganizationRoleController {

    @ApiOperation(value = "查询组织角色", notes = "查询组织角色", position = 1)
    @GetMapping("/{organizationId}organizationId")
    Result<List<OrganizationRoleVO>> findOne(@ApiParam(value = "组织id", required = true) @PathVariable String organizationId);

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/{organizationId}organizationId")
    Result<List<OrganizationRoleVO>> add(@ApiParam(value = "组织id", required = true) @PathVariable String organizationId,
                                         @ApiParam(value = "组织角色dto", required = true) @RequestBody @Validated List<OrganizationRoleDTO> organizationRoleDTOList);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{organizationId}organizationId")
    Result deleteByOrganizationId(@ApiParam(value = "组织id", required = true) @PathVariable String organizationId);

}
