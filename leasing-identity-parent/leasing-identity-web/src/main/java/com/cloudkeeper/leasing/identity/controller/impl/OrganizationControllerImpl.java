package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.OrganizationController;
import com.cloudkeeper.leasing.identity.domain.Organization;
import com.cloudkeeper.leasing.identity.dto.organization.OrganizationDTO;
import com.cloudkeeper.leasing.identity.dto.organization.OrganizationSearchable;
import com.cloudkeeper.leasing.identity.service.OrganizationService;
import com.cloudkeeper.leasing.identity.vo.OrganizationVO;
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
 * 组织 controller
 * @author jerry
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationControllerImpl implements OrganizationController {

    /** 组织 service */
    private final OrganizationService organizationService;

    @Override
    public Result<OrganizationVO> findOne(@ApiParam(value = "组织id", required = true) @PathVariable String id) {
        Optional<Organization> organizationOptional = organizationService.findOptionalById(id);
        return organizationOptional.map(organization -> Result.of(organization.convert(OrganizationVO.class))).orElseGet(() -> Result.of("组织不存在"));
    }

    @Override
    public Result<OrganizationVO> add(@ApiParam(value = "组织dto", required = true) @RequestBody @Validated OrganizationDTO organizationDTO) {
        Organization organization = organizationService.save(organizationDTO.convert(Organization.class));
        return Result.ofAddSuccess(organization.convert(OrganizationVO.class));
    }

    @Override
    public Result<OrganizationVO> update(@ApiParam(value = "组织id", required = true) @PathVariable String id,
                                         @ApiParam(value = "组织dto", required = true) @RequestBody @Validated OrganizationDTO organizationDTO) {
        Optional<Organization> organizationOptional = organizationService.findOptionalById(id);
        if (!organizationOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        Organization organization = organizationOptional.get();
        BeanUtils.copyProperties(organizationDTO, organization);
        organization = organizationService.save(organization);
        return Result.ofUpdateSuccess(organization.convert(OrganizationVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "组织id", required = true) @PathVariable String id) {
        organizationService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<OrganizationVO>> list(@ApiParam(value = "组织查询条件", required = true) @RequestBody OrganizationSearchable organizationSearchable,
                                             @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Organization> organizationList = organizationService.findAll(organizationSearchable, sort);
        List<OrganizationVO> organizationVOList = Organization.convert(organizationList, OrganizationVO.class);
        return Result.of(organizationVOList);
    }

    @Override
    public Result<Page<OrganizationVO>> page(@ApiParam(value = "组织查询条件", required = true) @RequestBody OrganizationSearchable organizationSearchable,
                                             @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Organization> organizationPage = organizationService.findAll(organizationSearchable, pageable);
        Page<OrganizationVO> organizationVOPage = Organization.convert(organizationPage, OrganizationVO.class);
        return Result.of(organizationVOPage);
    }

    @Override
    public Result<OrganizationVO> tree() {
        OrganizationVO organizationVO = organizationService.findTree();
        return Result.of(organizationVO);
    }

    @Override
    public Result<Boolean> existsCode(@ApiParam(value = "编码", required = true) @PathVariable String code,
                                      @ApiParam(value = "组织父id", required = true) @PathVariable String parentId,
                                      @ApiParam(value = "组织id") @PathVariable(required = false) String id) {
        boolean exists = organizationService.existsCode(code, parentId, id);
        return Result.of(exists);
    }

}
