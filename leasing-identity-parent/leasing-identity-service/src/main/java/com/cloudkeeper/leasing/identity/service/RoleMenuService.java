package com.cloudkeeper.leasing.identity.service;


import com.cloudkeeper.leasing.identity.domain.RoleMenu;
import com.cloudkeeper.leasing.base.service.BaseService;
import com.cloudkeeper.leasing.identity.domain.SysRoutes;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 角色菜单 service
 * @author jerry
 */
public interface RoleMenuService extends BaseService<RoleMenu> {

    /**
     * 查询列表 根据角色id
     * @param roleId 角色id
     * @return 角色菜单关系列表
     */
    @Nonnull
    List<RoleMenu> findAllByRoleId(@Nonnull String roleId);

    /**
     * 删除角色与菜单的关系
     * @param roleId 角色id
     */
    void deleteAllByRoleId(@Nonnull String roleId);

    /**
     * 批量保存
     * @param roleId 角色id
     * @param menuCodeList 菜单编码集合
     * @return 角色菜单关系集合
     */
    @Nonnull
    List<RoleMenu> save(@Nonnull String roleId, @Nonnull List<String> menuCodeList);

    /**
     * 获取用户的所有菜单集合
     * @param principalId 用户id
     * @return 菜单集合
     */
    @Nonnull
    List<SysRoutes> findAllMenuCodeByPrincipalId(@Nonnull String principalId);

}
