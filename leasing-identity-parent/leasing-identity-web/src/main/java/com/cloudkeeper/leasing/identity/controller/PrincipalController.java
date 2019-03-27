package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.dto.principal.PrincipalAddDTO;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalEditDTO;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalLoginDTO;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalSearchable;
import com.cloudkeeper.leasing.identity.vo.PrincipalVO;
import com.cloudkeeper.leasing.base.annotation.Authorization;
import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.bean.identity.to.PrincipalTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户 controller
 * @author jerry
 */
@Api(value = "用户", tags = "用户")
@RequestMapping("/principal")
public interface PrincipalController {

    @ApiOperation(value = "查询用户", notes = "查询用户", position = 1)
    @GetMapping("/{id}id")
    Result<PrincipalVO> findOne(@ApiParam(value = "用户id", required = true) @PathVariable String id);

    @ApiOperation(value = "查询用户", notes = "查询用户", position = 1)
    @GetMapping("/to/{id}id")
    Result<PrincipalTO> toFindOne(@ApiParam(value = "用户id", required = true) @PathVariable String id);

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<PrincipalVO> add(@ApiParam(value = "用户dto", required = true) @RequestBody @Validated PrincipalAddDTO principalAddDTO);

    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<PrincipalVO> update(@ApiParam(value = "用户id", required = true) @PathVariable String id,
                               @ApiParam(value = "用户dto", required = true) @RequestBody @Validated PrincipalEditDTO principalEditDTO);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "用户id", required = true) @PathVariable String id);

    @ApiOperation(value = "列表查询", notes = "列表查询<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 5)
    @PostMapping("/list")
    Result<List<PrincipalVO>> list(@ApiParam(value = "用户查询条件", required = true) @RequestBody PrincipalSearchable principalSearchable,
                                   @ApiParam(value = "排序条件", required = true) Sort sort);

    /**
     * 分页查询条件格式
     * api/principal/page?page=0&size=10&sort=code,desc&sort=name,desc
     * 分页参数：
     * page：第几页，默认为0，是第一页
     * size：分页大小，默认为20，在配置文件可以修改spring.data.controller.pageable.default-page-size
     * sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc
     */
    @ApiOperation(value = "分页查询", notes = "分页查询<br/>page：第几页，默认为0，是第一页<br/>size：分页大小, 默认为10<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 6)
    @PostMapping("/page")
    Result<Page<PrincipalVO>> page(@ApiParam(value = "用户查询条件", required = true) @RequestBody PrincipalSearchable principalSearchable,
                                   @ApiParam(value = "分页参数", required = true) Pageable pageable);

    @ApiOperation(value = "登录", notes = "登录", position = 7)
    @PostMapping("/login")
    @Authorization(required = false)
    Result<String> login(@ApiParam(value = "用户dto", required = true) @RequestBody @Validated PrincipalLoginDTO principalLoginDTO);

    @ApiOperation(value = "分页查询 组织code", notes = "分页查询", position = 8)
    @PostMapping("/page/{organizationFullCode}organizationFullCode")
    Result<Page<PrincipalVO>> page(@ApiParam(value = "组织编码", required = true) @PathVariable String organizationFullCode,
                                   @ApiParam(value = "用户查询条件", required = true) @RequestBody PrincipalSearchable principalSearchable,
                                   @ApiParam(value = "分页参数", required = true) Pageable pageable);

    @ApiOperation(value = "修改密码", notes = "修改密码", position = 9)
    @PutMapping("/{id}id/{password}password")
    Result<PrincipalVO> update(@ApiParam(value = "用户id", required = true) @PathVariable String id,
                               @ApiParam(value = "密码", required = true) @PathVariable String password);

    @ApiOperation(value = "编码存在校验", notes = "编码存在校验", position = 10)
    @GetMapping("/exists/{code}code/{id}id")
    Result<Boolean> existsCode(@ApiParam(value = "编码", required = true) @PathVariable String code,
                               @ApiParam(value = "组织id") @PathVariable(required = false) String id);

    @ApiOperation(value = "逻辑删除（0启用/1禁用）", notes = "逻辑删除（0启用/1禁用）", position = 11)
    @PutMapping("/tombstone/{id}id/{isDelete}isDelete")
    Result<PrincipalVO> tombstone(@ApiParam(value = "组织id", required = true) @PathVariable String id,
                                  @ApiParam(value = "是否删除", required = true) @PathVariable Integer isDelete);


    @ApiOperation(value = "获取用户所有信息，岗位、角色、菜单", notes = "获取用户所有信息，岗位、角色、菜单", position = 12)
    @GetMapping("/allInfo/{id}id")
    Result<PrincipalVO> findAllInfo(@ApiParam(value = "用户id", required = true) @PathVariable String id);

    @ApiOperation(value = "获取用户所有信息，岗位、角色、菜单", notes = "获取用户所有信息，岗位、角色、菜单", position = 12)
    @GetMapping("/allInfo")
    Result<PrincipalVO> findAllInfo(HttpServletRequest request);

}
