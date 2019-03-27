package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.dto.organization.OrganizationDTO;
import com.cloudkeeper.leasing.identity.dto.organization.OrganizationSearchable;
import com.cloudkeeper.leasing.identity.vo.OrganizationVO;
import com.cloudkeeper.leasing.base.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 组织 controller
 * @author jerry
 */
@Api(value = "组织", tags = "组织")
@RequestMapping("/organization")
public interface OrganizationController {

    @ApiOperation(value = "查询组织", notes = "查询组织", position = 1)
    @GetMapping("/{id}id")
    Result<OrganizationVO> findOne(@ApiParam(value = "组织id", required = true) @PathVariable String id);

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<OrganizationVO> add(@ApiParam(value = "组织dto", required = true) @RequestBody @Validated OrganizationDTO organizationDTO);

    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<OrganizationVO> update(@ApiParam(value = "组织id", required = true) @PathVariable String id,
                                  @ApiParam(value = "组织dto", required = true) @RequestBody @Validated OrganizationDTO organizationDTO);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "组织id", required = true) @PathVariable String id);

    @ApiOperation(value = "列表查询", notes = "列表查询", position = 5)
    @PostMapping("/list")
    Result<List<OrganizationVO>> list(@ApiParam(value = "组织查询条件", required = true) @RequestBody OrganizationSearchable organizationSearchable,
                                      @ApiParam(value = "排序条件", required = true) Sort sort);

    @ApiOperation(value = "分页查询", notes = "分页查询", position = 6)
    @PostMapping("/page")
    Result<Page<OrganizationVO>> page(@ApiParam(value = "组织查询条件", required = true) @RequestBody OrganizationSearchable organizationSearchable,
                                      @ApiParam(value = "分页参数", required = true) Pageable pageable);

    @ApiOperation(value = "组织树查询", notes = "组织树查询", position = 7)
    @GetMapping("/tree")
    Result<OrganizationVO> tree();

    @ApiOperation(value = "编码存在校验", notes = "编码存在校验", position = 8)
    @GetMapping("/exists/{code}code/{parentId}parentId/{id}id")
    Result<Boolean> existsCode(@ApiParam(value = "编码", required = true) @PathVariable String code,
                               @ApiParam(value = "组织父id", required = true) @PathVariable String parentId,
                               @ApiParam(value = "组织id") @PathVariable(required = false) String id);

}
