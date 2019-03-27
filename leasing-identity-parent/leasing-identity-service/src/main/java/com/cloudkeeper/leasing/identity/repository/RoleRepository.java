package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.Role;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;

/**
 * 角色 repository
 * @author jerry
 */
@Repository
public interface RoleRepository extends BaseRepository<Role> {

    /**
     * 是否存在
     * @param code 编码
     * @param id 主键
     * @return true 存在
     */
    boolean existsByCodeAndIdNot(@Nonnull String code, @Nonnull String id);

    /**
     * 是否存在
     * @param code 编码
     * @return true 存在
     */
    boolean existsByCode(@Nonnull String code);
}
