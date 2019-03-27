package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.OrganizationRoleController;
import com.cloudkeeper.leasing.identity.domain.OrganizationRole;
import com.cloudkeeper.leasing.identity.dto.organizationrole.OrganizationRoleDTO;
import com.cloudkeeper.leasing.identity.service.OrganizationRoleService;
import com.cloudkeeper.leasing.identity.vo.OrganizationRoleVO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 组织角色 controller
 * @author jerry
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationRoleControllerImpl implements OrganizationRoleController {

    /** 组织角色 service */
    private final OrganizationRoleService organizationRoleService;

    @Override
    public Result<List<OrganizationRoleVO>> findOne(@ApiParam(value = "组织id", required = true) @PathVariable String organizationId) {
        List<OrganizationRole> organizationRoleList = organizationRoleService.findAllByOrganizationId(organizationId);
        return Result.of(OrganizationRole.convert(organizationRoleList, OrganizationRoleVO.class));
    }

    @Override
    public Result<List<OrganizationRoleVO>> add(@ApiParam(value = "组织id", required = true) @PathVariable String organizationId,
                                                @ApiParam(value = "组织角色dto", required = true) @RequestBody @Validated List<OrganizationRoleDTO> organizationRoleDTOList) {
        List<OrganizationRole> organizationRoleList = organizationRoleService.save(organizationId, organizationRoleDTOList);
        return Result.ofAddSuccess(OrganizationRole.convert(organizationRoleList, OrganizationRoleVO.class));
    }

    @Override
    public Result deleteByOrganizationId(@ApiParam(value = "组织id", required = true) @PathVariable String organizationId) {
        organizationRoleService.deleteAllByOrganizationId(organizationId);
        return Result.ofDeleteSuccess();
    }

}
