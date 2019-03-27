package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.dto.principalorganization.PrincipalOrganizationDTO;
import com.cloudkeeper.leasing.identity.vo.PrincipalOrganizationVO;
import com.cloudkeeper.leasing.base.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户组织 controller
 * @author jerry
 */
@Api(value = "用户组织", tags = "用户组织")
@RequestMapping("/principalOrganization")
public interface PrincipalOrganizationController {

    @ApiOperation(value = "查询用户组织", notes = "查询用户组织", position = 1)
    @GetMapping("/{principalId}principalId")
    Result<List<PrincipalOrganizationVO>> findOne(@ApiParam(value = "用户id", required = true) @PathVariable String principalId);

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/{principalId}principalId")
    Result<List<PrincipalOrganizationVO>> add(@ApiParam(value = "用户id", required = true) @PathVariable String principalId,
                                              @ApiParam(value = "用户组织dto", required = true) @RequestBody @Validated List<PrincipalOrganizationDTO> principalOrganizationDTOList);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{principalId}principalId")
    Result deleteByPrincipalId(@ApiParam(value = "用户id", required = true) @PathVariable String principalId);

}
