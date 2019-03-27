package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.PrincipalOrganization;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 用户组织 repository
 * @author jerry
 */
@Repository
public interface PrincipalOrganizationRepository extends BaseRepository<PrincipalOrganization> {

    /**
     * 查询列表 根据用户id
     * @param principalId 用户id
     * @return 用户组织关系列表
     */
    @Nonnull
    List<PrincipalOrganization> findAllByPrincipalIdOrderByIsPartAsc(@Nonnull String principalId);

    /**
     * 删除用户与组织的关系
     * @param principalId 用户id
     */
    void deleteAllByPrincipalId(@Nonnull String principalId);

    /**
     * 查询用户组织关系（主岗）
     * @param principalId 用户id
     * @return 用户主岗
     */
    @Query("from PrincipalOrganization where principalId = ?1 and isPart = 0")
    PrincipalOrganization findByPrincipalIdAndIsPart(@Nonnull String principalId);

}
