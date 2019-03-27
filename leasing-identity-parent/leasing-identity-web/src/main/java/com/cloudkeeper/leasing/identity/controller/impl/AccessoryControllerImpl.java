package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.AccessoryController;
import com.cloudkeeper.leasing.identity.domain.Accessory;
import com.cloudkeeper.leasing.identity.dto.accessory.AccessoryDTO;
import com.cloudkeeper.leasing.identity.dto.accessory.AccessorySearchable;
import com.cloudkeeper.leasing.identity.service.AccessoryService;
import com.cloudkeeper.leasing.identity.vo.AccessoryVO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * 系统附件 controller
 * @author asher
 */
@RestController
public class AccessoryControllerImpl implements AccessoryController {

    /** 系统附件 service */
    @Autowired
    private AccessoryService accessoryService;

    @Override
    public Result<AccessoryVO> findOne(@ApiParam(value = "系统附件id", required = true) @PathVariable String id) {
        Optional<Accessory> accessoryOptional = accessoryService.findOptionalById(id);
        return accessoryOptional.map(accessory -> Result.of(accessory.convert(AccessoryVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<AccessoryVO> add(@ApiParam(value = "系统附件 DTO", required = true) AccessoryDTO accessoryDTO, @RequestParam("file") MultipartFile file) {
        Accessory accessory = accessoryService.save(accessoryDTO.convert(Accessory.class), file);
        return Result.ofAddSuccess(accessory.convert(AccessoryVO.class));
    }

    @Override
    public Result<AccessoryVO> update(@ApiParam(value = "系统附件id", required = true) @PathVariable String id,
        @ApiParam(value = "系统附件 DTO", required = true) @RequestBody @Validated AccessoryDTO accessoryDTO) {
        Optional<Accessory> accessoryOptional = accessoryService.findOptionalById(id);
        if (!accessoryOptional.isPresent()) {
            return Result.ofLost();
        }
        Accessory accessory = accessoryOptional.get();
        BeanUtils.copyProperties(accessoryDTO, accessory);
        accessory = accessoryService.save(accessory);
        return Result.ofUpdateSuccess(accessory.convert(AccessoryVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "系统附件id", required = true) @PathVariable String id) {
        accessoryService.deleteAndFile(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<AccessoryVO>> list(@ApiParam(value = "系统附件查询条件", required = true) @RequestBody AccessorySearchable accessorySearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Accessory> accessoryList = accessoryService.findAll(accessorySearchable, sort);
        List<AccessoryVO> accessoryVOList = Accessory.convert(accessoryList, AccessoryVO.class);
        return Result.of(accessoryVOList);
    }

    @Override
    public Result<Page<AccessoryVO>> page(@ApiParam(value = "系统附件查询条件", required = true) @RequestBody AccessorySearchable accessorySearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Accessory> accessoryPage = accessoryService.findAll(accessorySearchable, pageable);
        Page<AccessoryVO> accessoryVOPage = Accessory.convert(accessoryPage, AccessoryVO.class);
        return Result.of(accessoryVOPage);
    }


    @Override
    public void download(@PathVariable String id, HttpServletResponse response) throws IOException {
        Accessory accessory = accessoryService.findById(id);
        accessoryService.download(accessory, response);
    }


}