package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SysLoginLogController;
import com.cloudkeeper.leasing.identity.domain.SysLoginLog;
import com.cloudkeeper.leasing.identity.dto.sysloginlog.SysLoginLogDTO;
import com.cloudkeeper.leasing.identity.dto.sysloginlog.SysLoginLogSearchable;
import com.cloudkeeper.leasing.identity.service.SysLoginLogService;
import com.cloudkeeper.leasing.identity.vo.SysLoginLogVO;
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
 * 登录日志 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysLoginLogControllerImpl implements SysLoginLogController {

    /** 登录日志 service */
    private final SysLoginLogService sysLoginLogService;

    @Override
    public Result<SysLoginLogVO> findOne(@ApiParam(value = "登录日志id", required = true) @PathVariable String id) {
        Optional<SysLoginLog> sysLoginLogOptional = sysLoginLogService.findOptionalById(id);
        return sysLoginLogOptional.map(sysLoginLog -> Result.of(sysLoginLog.convert(SysLoginLogVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SysLoginLogVO> add(@ApiParam(value = "登录日志 DTO", required = true) @RequestBody @Validated SysLoginLogDTO sysLoginLogDTO) {
        SysLoginLog sysLoginLog = sysLoginLogService.save(sysLoginLogDTO.convert(SysLoginLog.class));
        return Result.ofAddSuccess(sysLoginLog.convert(SysLoginLogVO.class));
    }

    @Override
    public Result<SysLoginLogVO> update(@ApiParam(value = "登录日志id", required = true) @PathVariable String id,
        @ApiParam(value = "登录日志 DTO", required = true) @RequestBody @Validated SysLoginLogDTO sysLoginLogDTO) {
        Optional<SysLoginLog> sysLoginLogOptional = sysLoginLogService.findOptionalById(id);
        if (!sysLoginLogOptional.isPresent()) {
            return Result.ofLost();
        }
        SysLoginLog sysLoginLog = sysLoginLogOptional.get();
        BeanUtils.copyProperties(sysLoginLogDTO, sysLoginLog);
        sysLoginLog = sysLoginLogService.save(sysLoginLog);
        return Result.ofUpdateSuccess(sysLoginLog.convert(SysLoginLogVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "登录日志id", required = true) @PathVariable String id) {
        sysLoginLogService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SysLoginLogVO>> list(@ApiParam(value = "登录日志查询条件", required = true) @RequestBody SysLoginLogSearchable sysLoginLogSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<SysLoginLog> sysLoginLogList = sysLoginLogService.findAll(sysLoginLogSearchable, sort);
        List<SysLoginLogVO> sysLoginLogVOList = SysLoginLog.convert(sysLoginLogList, SysLoginLogVO.class);
        return Result.of(sysLoginLogVOList);
    }

    @Override
    public Result<Page<SysLoginLogVO>> page(@ApiParam(value = "登录日志查询条件", required = true) @RequestBody SysLoginLogSearchable sysLoginLogSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SysLoginLog> sysLoginLogPage = sysLoginLogService.findAll(sysLoginLogSearchable, pageable);
        Page<SysLoginLogVO> sysLoginLogVOPage = SysLoginLog.convert(sysLoginLogPage, SysLoginLogVO.class);
        return Result.of(sysLoginLogVOPage);
    }

}