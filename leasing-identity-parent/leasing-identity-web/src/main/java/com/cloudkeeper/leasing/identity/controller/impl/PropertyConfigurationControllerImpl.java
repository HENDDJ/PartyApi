package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.PropertyConfigurationController;
import com.cloudkeeper.leasing.identity.domain.PropertyConfiguration;
import com.cloudkeeper.leasing.identity.dto.propertyconfiguration.PropertyConfigurationDTO;
import com.cloudkeeper.leasing.identity.dto.propertyconfiguration.PropertyConfigurationSearchable;
import com.cloudkeeper.leasing.identity.service.PropertyConfigurationService;
import com.cloudkeeper.leasing.identity.vo.PropertyConfigurationVO;
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
 * @author zhuwu
 * @version V1.0
 * @since 2018/9/30
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PropertyConfigurationControllerImpl implements PropertyConfigurationController {

    /** 系统属性service */
    private final PropertyConfigurationService propertyConfigurationService;

    @Override
    public Result<PropertyConfigurationVO> findOne(@ApiParam(value = "系统属性id", required = true) @PathVariable String id) {
        Optional<PropertyConfiguration> propertyConfigurationOptional = propertyConfigurationService.findOptionalById(id);
        return propertyConfigurationOptional.map(propertyConfiguration -> Result.of(propertyConfiguration.convert(PropertyConfigurationVO.class))).orElseGet(() -> Result.of("系统属性不存在"));
    }

    @Override
    public Result<PropertyConfigurationVO> add(@ApiParam(value = "系统属性dto", required = true) @RequestBody @Validated PropertyConfigurationDTO propertyConfigurationDTO) {
        PropertyConfiguration propertyConfiguration = propertyConfigurationService.save(propertyConfigurationDTO.convert(PropertyConfiguration.class));
        return Result.ofAddSuccess(propertyConfiguration.convert(PropertyConfigurationVO.class));
    }

    @Override
    public Result<PropertyConfigurationVO> update(@ApiParam(value = "系统属性id", required = true) @PathVariable String id,
                                                  @ApiParam(value = "系统属性dto", required = true) @RequestBody @Validated PropertyConfigurationDTO propertyConfigurationDTO) {
        Optional<PropertyConfiguration> propertyConfigurationOptional = propertyConfigurationService.findOptionalById(id);
        if (!propertyConfigurationOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        PropertyConfiguration propertyConfiguration = propertyConfigurationOptional.get();
        BeanUtils.copyProperties(propertyConfigurationDTO, propertyConfiguration);
        propertyConfiguration = propertyConfigurationService.save(propertyConfiguration);
        return Result.ofUpdateSuccess(propertyConfiguration.convert(PropertyConfigurationVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "系统属性id", required = true) @PathVariable String id) {
        propertyConfigurationService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<PropertyConfigurationVO>> list(@ApiParam(value = "系统属性查询条件", required = true) @RequestBody PropertyConfigurationSearchable propertyConfigurationSearchable,
                                                      @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<PropertyConfiguration> propertyConfigurationList = propertyConfigurationService.findAll(propertyConfigurationSearchable, sort);
        List<PropertyConfigurationVO> propertyConfigurationVOList = PropertyConfiguration.convert(propertyConfigurationList, PropertyConfigurationVO.class);
        return Result.of(propertyConfigurationVOList);
    }

    @Override
    public Result<Page<PropertyConfigurationVO>> page(@ApiParam(value = "系统属性查询条件", required = true) @RequestBody PropertyConfigurationSearchable propertyConfigurationSearchable,
                                                      @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<PropertyConfiguration> propertyConfigurationPage = propertyConfigurationService.findAll(propertyConfigurationSearchable, pageable);
        Page<PropertyConfigurationVO> propertyConfigurationVOPage = PropertyConfiguration.convert(propertyConfigurationPage, PropertyConfigurationVO.class);
        return Result.of(propertyConfigurationVOPage);
    }
}
