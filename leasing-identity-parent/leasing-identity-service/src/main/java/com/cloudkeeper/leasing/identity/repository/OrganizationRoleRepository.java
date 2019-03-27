package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.OrganizationRole;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 组织角色 repository
 * @author jerry
 */
@Repository
public interface OrganizationRoleRepository extends BaseRepository<OrganizationRole> {

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

}
