package com.cloudkeeper.leasing.identity.service;


import com.cloudkeeper.leasing.identity.domain.OrganizationRole;
import com.cloudkeeper.leasing.identity.dto.organizationrole.OrganizationRoleDTO;
import com.cloudkeeper.leasing.base.service.BaseService;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 组织角色 service
 * @author jerry
 */
public interface OrganizationRoleService extends BaseService<OrganizationRole> {

    /**
     * 查询列表 根据组织id
     * @param organizationId 组织id
     * @return 组织角色关系列表
     */
    @Nonnull
    List<OrganizationRole> findAllByOrganizationId(@Nonnull String organizationId);

    /**
     * 删除组织与角色的关系
     * @param organizationId 组织id
     */
    void deleteAllByOrganizationId(@Nonnull String organizationId);

    /**
     * 批量保存
     * @param organizationId 组织id
     * @param organizationRoleDTOList 组织角色关系dto集合
     * @return 组织角色关系集合
     */
    @Nonnull
    List<OrganizationRole> save(@Nonnull String organizationId, @Nonnull List<OrganizationRoleDTO> organizationRoleDTOList);

}
