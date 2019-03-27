package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.EnvironmentData;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 环境数据类 repository
 * @author asher
 */
@Repository
public interface EnvironmentDataRepository extends BaseRepository<EnvironmentData> {

}