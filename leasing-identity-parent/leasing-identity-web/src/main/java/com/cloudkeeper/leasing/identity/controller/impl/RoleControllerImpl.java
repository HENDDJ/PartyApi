package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.RoleController;
import com.cloudkeeper.leasing.identity.domain.Role;
import com.cloudkeeper.leasing.identity.dto.role.RoleDTO;
import com.cloudkeeper.leasing.identity.dto.role.RoleSearchable;
import com.cloudkeeper.leasing.identity.service.RoleService;
import com.cloudkeeper.leasing.identity.vo.RoleVO;
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
 * 角色 controller
 * @author jerry
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleControllerImpl implements RoleController {

    /** 角色 service */
    private final RoleService roleService;

    @Override
    public Result<RoleVO> findOne(@ApiParam(value = "角色id", required = true) @PathVariable String id) {
        Optional<Role> roleOptional = roleService.findOptionalById(id);
        return roleOptional.map(role -> Result.of(role.convert(RoleVO.class))).orElseGet(() -> Result.of("角色不存在"));
    }

    @Override
    public Result<RoleVO> add(@ApiParam(value = "角色dto", required = true) @RequestBody @Validated RoleDTO roleDTO) {
        Role role = roleService.save(roleDTO.convert(Role.class));
        return Result.ofAddSuccess(role.convert(RoleVO.class));
    }

    @Override
    public Result<RoleVO> update(@ApiParam(value = "角色id", required = true) @PathVariable String id,
                                 @ApiParam(value = "角色dto", required = true) @RequestBody @Validated RoleDTO roleDTO) {
        Optional<Role> roleOptional = roleService.findOptionalById(id);
        if (!roleOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        Role role = roleOptional.get();
        BeanUtils.copyProperties(roleDTO, role);
        role = roleService.save(role);
        return Result.ofUpdateSuccess(role.convert(RoleVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "角色id", required = true) @PathVariable String id) {
        roleService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<RoleVO>> list(@ApiParam(value = "角色查询条件", required = true) @RequestBody RoleSearchable roleSearchable,
                                     @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Role> roleList = roleService.findAll(roleSearchable, sort);
        List<RoleVO> roleVOList = Role.convert(roleList, RoleVO.class);
        return Result.of(roleVOList);
    }

    @Override
    public Result<Page<RoleVO>> page(@ApiParam(value = "角色查询条件", required = true) @RequestBody RoleSearchable roleSearchable,
                                     @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Role> rolePage = roleService.findAll(roleSearchable, pageable);
        Page<RoleVO> roleVOPage = Role.convert(rolePage, RoleVO.class);
        return Result.of(roleVOPage);
    }

    @Override
    public Result<Boolean> existsCode(@ApiParam(value = "编码", required = true) @PathVariable String code,
                                      @ApiParam(value = "角色id") @PathVariable(required = false) String id) {
        boolean exists = roleService.existsCode(code, id);
        return Result.of(exists);
    }

}
