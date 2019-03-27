package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.Camera;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 监控 repository
 * @author asher
 */
@Repository
public interface CameraRepository extends BaseRepository<Camera> {

}