package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.CameraController;
import com.cloudkeeper.leasing.identity.domain.Camera;
import com.cloudkeeper.leasing.identity.dto.camera.CameraDTO;
import com.cloudkeeper.leasing.identity.dto.camera.CameraSearchable;
import com.cloudkeeper.leasing.identity.service.CameraService;
import com.cloudkeeper.leasing.identity.vo.CameraVO;
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
 * 监控 controller
 * @author asher
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CameraControllerImpl implements CameraController {

    /** 监控 service */
    private final CameraService cameraService;

    @Override
    public Result<CameraVO> findOne(@ApiParam(value = "监控id", required = true) @PathVariable String id) {
        Optional<Camera> cameraOptional = cameraService.findOptionalById(id);
        return cameraOptional.map(camera -> Result.of(camera.convert(CameraVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<CameraVO> add(@ApiParam(value = "监控 DTO", required = true) @RequestBody @Validated CameraDTO cameraDTO) {
        Camera camera = cameraService.save(cameraDTO.convert(Camera.class));
        return Result.ofAddSuccess(camera.convert(CameraVO.class));
    }

    @Override
    public Result<CameraVO> update(@ApiParam(value = "监控id", required = true) @PathVariable String id,
        @ApiParam(value = "监控 DTO", required = true) @RequestBody @Validated CameraDTO cameraDTO) {
        Optional<Camera> cameraOptional = cameraService.findOptionalById(id);
        if (!cameraOptional.isPresent()) {
            return Result.ofLost();
        }
        Camera camera = cameraOptional.get();
        BeanUtils.copyProperties(cameraDTO, camera);
        camera = cameraService.save(camera);
        return Result.ofUpdateSuccess(camera.convert(CameraVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "监控id", required = true) @PathVariable String id) {
        cameraService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<CameraVO>> list(@ApiParam(value = "监控查询条件", required = true) @RequestBody CameraSearchable cameraSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Camera> cameraList = cameraService.findAll(cameraSearchable, sort);
        List<CameraVO> cameraVOList = Camera.convert(cameraList, CameraVO.class);
        return Result.of(cameraVOList);
    }

    @Override
    public Result<Page<CameraVO>> page(@ApiParam(value = "监控查询条件", required = true) @RequestBody CameraSearchable cameraSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Camera> cameraPage = cameraService.findAll(cameraSearchable, pageable);
        Page<CameraVO> cameraVOPage = Camera.convert(cameraPage, CameraVO.class);
        return Result.of(cameraVOPage);
    }

}