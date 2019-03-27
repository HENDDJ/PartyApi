package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.domain.SysRoutes;
import com.cloudkeeper.leasing.identity.vo.RoleMenuVO;
import com.cloudkeeper.leasing.base.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 角色菜单 controller
 * @author jerry
 */
@Api(value = "角色菜单", tags = "角色菜单")
@RequestMapping("/roleMenu")
public interface RoleMenuController {

    @ApiOperation(value = "查询角色菜单", notes = "查询角色菜单", position = 1)
    @GetMapping("/{roleId}roleId")
    Result<List<RoleMenuVO>> findOne(@ApiParam(value = "角色id", required = true) @PathVariable String roleId);

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/{roleId}roleId")
    Result<List<RoleMenuVO>> add(@ApiParam(value = "角色id", required = true) @PathVariable String roleId,
                                 @ApiParam(value = "角色菜单dto", required = true) @RequestBody List<String> menuCodeList);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{roleId}roleId")
    Result deleteByRoleId(@ApiParam(value = "角色id", required = true) @PathVariable String roleId);

    @ApiOperation(value = "查询用户菜单", notes = "查询用户菜单", position = 5)
    @GetMapping("/menu")
    Result<List<SysRoutes>> findMenuCode(HttpServletRequest request);

}
