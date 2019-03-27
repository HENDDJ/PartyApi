package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.PrincipalOrganizationController;
import com.cloudkeeper.leasing.identity.domain.PrincipalOrganization;
import com.cloudkeeper.leasing.identity.dto.principalorganization.PrincipalOrganizationDTO;
import com.cloudkeeper.leasing.identity.service.PrincipalOrganizationService;
import com.cloudkeeper.leasing.identity.vo.PrincipalOrganizationVO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户组织 controller
 * @author jerry
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PrincipalOrganizationControllerImpl implements PrincipalOrganizationController {

    /** 用户组织 service */
    private final PrincipalOrganizationService principalOrganizationService;

    @Override
    public Result<List<PrincipalOrganizationVO>> findOne(@ApiParam(value = "用户id", required = true) @PathVariable String principalId) {
        List<PrincipalOrganization> principalOrganizationList = principalOrganizationService.findAllByPrincipalId(principalId);
        return Result.of(PrincipalOrganization.convert(principalOrganizationList, PrincipalOrganizationVO.class));
    }

    @Override
    public Result<List<PrincipalOrganizationVO>> add(@ApiParam(value = "用户id", required = true) @PathVariable String principalId,
                                                     @ApiParam(value = "用户组织dto", required = true) @RequestBody @Validated List<PrincipalOrganizationDTO> principalOrganizationDTOList) {
        List<PrincipalOrganization> principalOrganizationList = principalOrganizationService.save(principalId, principalOrganizationDTOList);
        return Result.ofAddSuccess(PrincipalOrganization.convert(principalOrganizationList, PrincipalOrganizationVO.class));
    }

    @Override
    public Result deleteByPrincipalId(@ApiParam(value = "用户id", required = true) @PathVariable String principalId) {
        principalOrganizationService.deleteAllByPrincipalId(principalId);
        return Result.ofDeleteSuccess();
    }

}
