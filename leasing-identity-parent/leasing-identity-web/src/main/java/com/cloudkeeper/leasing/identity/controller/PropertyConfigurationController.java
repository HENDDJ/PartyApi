package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.dto.propertyconfiguration.PropertyConfigurationDTO;
import com.cloudkeeper.leasing.identity.dto.propertyconfiguration.PropertyConfigurationSearchable;
import com.cloudkeeper.leasing.identity.vo.PropertyConfigurationVO;
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
 * @author zhuwu
 * @version V1.0
 * @since 2018/9/30
 */
@Api(value = "系统属性", tags = "系统属性")
@RequestMapping("/propertyConfiguration")
public interface PropertyConfigurationController {

    @ApiOperation(value = "查询系统属性", notes = "查询系统属性", position = 1)
    @GetMapping("/{id}id")
    Result<PropertyConfigurationVO> findOne(@ApiParam(value = "系统属性id", required = true) @PathVariable String id);

    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<PropertyConfigurationVO> add(@ApiParam(value = "系统属性dto", required = true) @RequestBody @Validated PropertyConfigurationDTO propertyConfigurationDTO);

    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<PropertyConfigurationVO> update(@ApiParam(value = "系统属性id", required = true) @PathVariable String id,
                                           @ApiParam(value = "系统属性dto", required = true) @RequestBody @Validated PropertyConfigurationDTO propertyConfigurationDTO);

    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "系统属性id", required = true) @PathVariable String id);

    @ApiOperation(value = "列表查询", notes = "列表查询", position = 5)
    @PostMapping("/list")
    Result<List<PropertyConfigurationVO>> list(@ApiParam(value = "系统属性查询条件", required = true) @RequestBody PropertyConfigurationSearchable propertyConfigurationSearchable,
                                               @ApiParam(value = "排序条件", required = true) Sort sort);

    @ApiOperation(value = "分页查询", notes = "分页查询", position = 6)
    @PostMapping("/page")
    Result<Page<PropertyConfigurationVO>> page(@ApiParam(value = "系统属性查询条件", required = true) @RequestBody PropertyConfigurationSearchable propertyConfigurationSearchable,
                                               @ApiParam(value = "分页参数", required = true) Pageable pageable);
}
