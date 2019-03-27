package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.Organization;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 组织 repository
 * @author jerry
 */
@Repository
public interface OrganizationRepository extends BaseRepository<Organization> {

    /**
     * 根据code，查询组织
     * @param code 编码
     * @return 组织
     */
    Organization findByCode(@Nonnull String code);

    /**
     * 根据父id，查询组织列表
     * @param parentId 父id
     * @return 组织列表
     */
    List<Organization> findAllByParentIdOrderBySortAsc(@Nonnull String parentId);

    /**
     * 是否存在
     * @param parentId 父id
     * @param code 编码
     * @param id 主键
     * @return true 存在
     */
    boolean existsByParentIdAndCodeAndIdNot(@Nonnull String parentId, @Nonnull String code, @Nonnull String id);

    /**
     * 是否存在
     * @param parentId 父id
     * @param code 编码
     * @return true 存在
     */
    boolean existsByParentIdAndCode(@Nonnull String parentId, @Nonnull String code);
}
