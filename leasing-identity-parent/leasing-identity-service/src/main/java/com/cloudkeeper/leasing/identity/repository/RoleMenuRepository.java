package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.RoleMenu;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 角色菜单 repository
 * @author jerry
 */
@Repository
public interface RoleMenuRepository extends BaseRepository<RoleMenu> {

    /**
     * 查询列表 根据角色id
     * @param roleId 角色id
     * @return 角色菜单关系列表
     */
    @Nonnull
    List<RoleMenu> findAllByRoleIdOrderByCreatedAtAsc(@Nonnull String roleId);

    /**
     * 删除角色与菜单的关系
     * @param roleId 角色id
     */
    void deleteAllByRoleId(@Nonnull String roleId);

    /**
     * 获取用户的所有菜单集合
     * @return 菜单集合
     */
//    @Nonnull
//    @Query("select distinct cirm.menuCode from RoleMenu cirm where exists (select 'X' from OrganizationRole cior where cirm.roleId = cior.roleId and exists (select 'X' from PrincipalOrganization cipo where cipo.organizationId = cior.organizationId and cipo.principalId = ?1))")
//    List<String> findAllMenuCodeByPrincipalId(@Nonnull String principalId);

}
