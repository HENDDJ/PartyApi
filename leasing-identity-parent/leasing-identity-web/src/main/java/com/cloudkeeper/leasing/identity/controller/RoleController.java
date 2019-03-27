package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.dto.role.RoleDTO;
import com.cloudkeeper.leasing.identity.dto.role.RoleSearchable;
import com.cloudkeeper.leasing.identity.vo.RoleVO;
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
 * 角色 controller
 * @author jerry
 */
@Api(value = "角色", tags = "角色")
@RequestMapping("/role")
public interface RoleController {

    @ApiOperation(value = "查询角色", notes = "查询角色", position = 1)
    @GetMapping("/{id}id")
    Result<RoleVO> findOne(@ApiParam(value = "角色id", required = true) @PathVariable String id);

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<RoleVO> add(@ApiParam(value = "角色dto", required = true) @RequestBody @Validated RoleDTO roleDTO);

    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<RoleVO> update(@ApiParam(value = "角色id", required = true) @PathVariable String id,
                          @ApiParam(value = "角色dto", required = true) @RequestBody @Validated RoleDTO roleDTO);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "角色id", required = true) @PathVariable String id);

    @ApiOperation(value = "列表查询", notes = "列表查询", position = 5)
    @PostMapping("/list")
    Result<List<RoleVO>> list(@ApiParam(value = "角色查询条件", required = true) @RequestBody RoleSearchable roleSearchable,
                              @ApiParam(value = "排序条件", required = true) Sort sort);

    @ApiOperation(value = "分页查询", notes = "分页查询", position = 6)
    @PostMapping("/page")
    Result<Page<RoleVO>> page(@ApiParam(value = "角色查询条件", required = true) @RequestBody RoleSearchable roleSearchable,
                              @ApiParam(value = "分页参数", required = true) Pageable pageable);

    @ApiOperation(value = "编码存在校验", notes = "编码存在校验", position = 8)
    @GetMapping("/exists/{code}code/{id}id")
    Result<Boolean> existsCode(@ApiParam(value = "编码", required = true) @PathVariable String code,
                               @ApiParam(value = "角色id") @PathVariable(required = false) String id);

}
