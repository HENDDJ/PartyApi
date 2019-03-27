package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.constant.AuthorizationConstants;
import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.RoleMenuController;
import com.cloudkeeper.leasing.identity.domain.RoleMenu;
import com.cloudkeeper.leasing.identity.domain.SysRoutes;
import com.cloudkeeper.leasing.identity.service.RoleMenuService;
import com.cloudkeeper.leasing.identity.vo.RoleMenuVO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 角色菜单 controller
 * @author jerry
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleMenuControllerImpl implements RoleMenuController {

    /** 角色菜单 service */
    private final RoleMenuService roleMenuService;

    @Override
    public Result<List<RoleMenuVO>> findOne(@ApiParam(value = "角色id", required = true) @PathVariable String roleId) {
        List<RoleMenu> roleMenuList = roleMenuService.findAllByRoleId(roleId);
        return Result.of(RoleMenu.convert(roleMenuList, RoleMenuVO.class));
    }

    @Override
    public Result<List<RoleMenuVO>> add(@ApiParam(value = "角色id", required = true) @PathVariable String roleId,
                                        @ApiParam(value = "角色菜单dto", required = true) @RequestBody List<String> menuCodeList) {
        List<RoleMenu> roleMenuList = roleMenuService.save(roleId, menuCodeList);
        return Result.ofAddSuccess(RoleMenu.convert(roleMenuList, RoleMenuVO.class));
    }

    @Override
    public Result deleteByRoleId(@ApiParam(value = "角色id", required = true) @PathVariable String roleId) {
        roleMenuService.deleteAllByRoleId(roleId);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SysRoutes>> findMenuCode(HttpServletRequest request) {
        String principalId = (String) request.getSession().getAttribute(AuthorizationConstants.CURRENT_USER_ID);
        List<SysRoutes> menus = roleMenuService.findAllMenuCodeByPrincipalId(principalId);
        return Result.of(menus);
    }

}
