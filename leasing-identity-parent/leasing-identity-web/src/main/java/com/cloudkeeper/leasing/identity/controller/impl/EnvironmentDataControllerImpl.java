package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.EnvironmentDataController;
import com.cloudkeeper.leasing.identity.domain.EnvironmentData;
import com.cloudkeeper.leasing.identity.dto.environmentdata.EnvironmentDataDTO;
import com.cloudkeeper.leasing.identity.dto.environmentdata.EnvironmentDataSearchable;
import com.cloudkeeper.leasing.identity.service.EnvironmentDataService;
import com.cloudkeeper.leasing.identity.vo.EnvironmentDataVO;
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
 * 环境数据类 controller
 * @author asher
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnvironmentDataControllerImpl implements EnvironmentDataController {

    /** 环境数据类 service */
    private final EnvironmentDataService environmentDataService;

    @Override
    public Result<EnvironmentDataVO> findOne(@ApiParam(value = "环境数据类id", required = true) @PathVariable String id) {
        Optional<EnvironmentData> environmentDataOptional = environmentDataService.findOptionalById(id);
        return environmentDataOptional.map(environmentData -> Result.of(environmentData.convert(EnvironmentDataVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<EnvironmentDataVO> add(@ApiParam(value = "环境数据类 DTO", required = true) @RequestBody @Validated EnvironmentDataDTO environmentDataDTO) {
        EnvironmentData environmentData = environmentDataService.save(environmentDataDTO.convert(EnvironmentData.class));
        return Result.ofAddSuccess(environmentData.convert(EnvironmentDataVO.class));
    }

    @Override
    public Result<EnvironmentDataVO> update(@ApiParam(value = "环境数据类id", required = true) @PathVariable String id,
        @ApiParam(value = "环境数据类 DTO", required = true) @RequestBody @Validated EnvironmentDataDTO environmentDataDTO) {
        Optional<EnvironmentData> environmentDataOptional = environmentDataService.findOptionalById(id);
        if (!environmentDataOptional.isPresent()) {
            return Result.ofLost();
        }
        EnvironmentData environmentData = environmentDataOptional.get();
        BeanUtils.copyProperties(environmentDataDTO, environmentData);
        environmentData = environmentDataService.save(environmentData);
        return Result.ofUpdateSuccess(environmentData.convert(EnvironmentDataVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "环境数据类id", required = true) @PathVariable String id) {
        environmentDataService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<EnvironmentDataVO>> list(@ApiParam(value = "环境数据类查询条件", required = true) @RequestBody EnvironmentDataSearchable environmentDataSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<EnvironmentData> environmentDataList = environmentDataService.findAll(environmentDataSearchable, sort);
        List<EnvironmentDataVO> environmentDataVOList = EnvironmentData.convert(environmentDataList, EnvironmentDataVO.class);
        return Result.of(environmentDataVOList);
    }

    @Override
    public Result<Page<EnvironmentDataVO>> page(@ApiParam(value = "环境数据类查询条件", required = true) @RequestBody EnvironmentDataSearchable environmentDataSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<EnvironmentData> environmentDataPage = environmentDataService.findAll(environmentDataSearchable, pageable);
        Page<EnvironmentDataVO> environmentDataVOPage = EnvironmentData.convert(environmentDataPage, EnvironmentDataVO.class);
        return Result.of(environmentDataVOPage);
    }

}