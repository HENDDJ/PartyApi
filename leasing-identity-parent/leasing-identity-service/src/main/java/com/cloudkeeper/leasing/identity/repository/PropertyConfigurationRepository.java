package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.PropertyConfiguration;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 系统属性Repository
 * @author zhuwu
 * @version V1.0
 * @since 2018/9/30
 */
@Repository
public interface PropertyConfigurationRepository extends BaseRepository<PropertyConfiguration> {
}
