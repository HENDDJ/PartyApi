package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.annotation.Authorization;
import com.cloudkeeper.leasing.base.constant.AuthorizationConstants;
import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.bean.identity.to.PrincipalTO;
import com.cloudkeeper.leasing.identity.controller.PrincipalController;
import com.cloudkeeper.leasing.identity.domain.Principal;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalAddDTO;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalEditDTO;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalLoginDTO;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalSearchable;
import com.cloudkeeper.leasing.identity.service.PrincipalService;
import com.cloudkeeper.leasing.identity.vo.PrincipalVO;
import io.swagger.annotations.ApiParam;
import liquibase.util.MD5Util;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * 用户 controller
 * @author jerry
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PrincipalControllerImpl implements PrincipalController {

    /** 用户 service */
    private final PrincipalService principalService;

    @Override
    public Result<PrincipalVO> findOne(@ApiParam(value = "用户id", required = true) @PathVariable String id) {
        Optional<Principal> principalOptional = principalService.findOptionalById(id);
        return principalOptional.map(principal -> Result.of(principal.convert(PrincipalVO.class))).orElseGet(() -> Result.of("用户不存在"));
    }

    @Override
    public Result<PrincipalTO> toFindOne(@ApiParam(value = "用户id", required = true) @PathVariable String id) {
        Optional<Principal> principalOptional = principalService.findOptionalById(id);
        return principalOptional.map(principal -> Result.of(principal.convert(PrincipalTO.class))).orElseGet(() -> Result.of("用户不存在"));
    }

    @Override
    public Result<PrincipalVO> add(@ApiParam(value = "用户dto", required = true) @RequestBody @Validated PrincipalAddDTO principalAddDTO) {
        principalAddDTO.setPassword(MD5Util.computeMD5(principalAddDTO.getPassword()));
        Principal principal = principalService.save(principalAddDTO.convert(Principal.class));
        return Result.ofAddSuccess(principal.convert(PrincipalVO.class));
    }

    @Override
    public Result<PrincipalVO> update(@ApiParam(value = "用户id", required = true) @PathVariable String id,
                                      @ApiParam(value = "用户dto", required = true) @RequestBody @Validated PrincipalEditDTO principalEditDTO) {
        Optional<Principal> principalOptional = principalService.findOptionalById(id);
        if (!principalOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        Principal principal = principalOptional.get();
        BeanUtils.copyProperties(principalEditDTO, principal);
        principal = principalService.save(principal);
        return Result.ofUpdateSuccess(principal.convert(PrincipalVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "用户id", required = true) @PathVariable String id) {
        principalService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<PrincipalVO>> list(@ApiParam(value = "用户查询条件", required = true) @RequestBody PrincipalSearchable principalSearchable,
                                          @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Principal> principalList = principalService.findAll(principalSearchable, sort);
        List<PrincipalVO> principalVOList = Principal.convert(principalList, PrincipalVO.class);
        return Result.of(principalVOList);
    }

    @Override
    public Result<Page<PrincipalVO>> page(@ApiParam(value = "用户查询条件", required = true) @RequestBody PrincipalSearchable principalSearchable,
                                          @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Principal> principalPage = principalService.findAll(principalSearchable, pageable);
        Page<PrincipalVO> principalVOPage = Principal.convert(principalPage, PrincipalVO.class);
        return Result.of(principalVOPage);
    }

    @Override
    @Authorization(required = false)
    public Result<String> login(@ApiParam(value = "用户dto", required = true) @RequestBody @Validated PrincipalLoginDTO principalLoginDTO) {
        return principalService.login(principalLoginDTO);
    }

    @Override
    public Result<Page<PrincipalVO>> page(@ApiParam(value = "组织编码", required = true) @PathVariable String organizationFullCode,
                                          @ApiParam(value = "用户查询条件", required = true) @RequestBody PrincipalSearchable principalSearchable,
                                          @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        principalSearchable.setOrganizationCode(organizationFullCode);
        Page<Principal> principalPage = principalService.findAll(principalSearchable, pageable);
        Page<PrincipalVO> principalVOPage = Principal.convert(principalPage, PrincipalVO.class);
        return Result.of(principalVOPage);
    }

    @Override
    public Result<PrincipalVO> update(@ApiParam(value = "用户id", required = true) @PathVariable String id,
                                      @ApiParam(value = "密码", required = true) @PathVariable String password) {
        Optional<Principal> principalOptional = principalService.findOptionalById(id);
        if (!principalOptional.isPresent()) {
            return Result.of(Result.ResultCode.FAIL.getCode(), "修改的数据不存在，请刷新后重试！");
        }
        Principal principal = principalOptional.get();
        principal.setPassword(MD5Util.computeMD5(password));
        principal = principalService.save(principal);
        return Result.ofUpdateSuccess(principal.convert(PrincipalVO.class));
    }

    @Override
    public Result<Boolean> existsCode(@ApiParam(value = "编码", required = true) @PathVariable String code,
                                      @ApiParam(value = "组织id") @PathVariable(required = false) String id) {
        boolean exists = principalService.existsCode(code, id);
        return Result.of(exists);
    }

    @Override
    public Result<PrincipalVO> tombstone(@ApiParam(value = "组织id", required = true) @PathVariable String id,
                                         @ApiParam(value = "是否删除", required = true) @PathVariable Integer isDelete) {
        Principal principal = principalService.updateIsDelete(id, isDelete);
        return Result.ofUpdateSuccess(principal.convert(PrincipalVO.class));
    }


    @Override
    public Result<PrincipalVO> findAllInfo(@ApiParam(value = "用户id", required = true) @PathVariable String id) {
        Optional<Principal> principalOptional = principalService.findOptionalById(id);
        return principalOptional.map(principal -> {
            PrincipalVO principalVO = principal.convert(PrincipalVO.class);
            principalService.loadChildrenVO(principalVO);
            return Result.of(principalVO);
        }).orElseGet(() -> Result.of("用户不存在"));
    }

    @Override
    public Result<PrincipalVO> findAllInfo(HttpServletRequest request) {
        String principalId = (String) request.getSession().getAttribute(AuthorizationConstants.CURRENT_USER_ID);
        Optional<Principal> principalOptional = principalService.findOptionalById(principalId);
        return principalOptional.map(principal -> {
            PrincipalVO principalVO = principal.convert(PrincipalVO.class);
            principalService.loadChildrenVO(principalVO);
            return Result.of(principalVO);
        }).orElseGet(() -> Result.of("用户不存在"));
    }

}
