package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.ProjectInfo;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 工程信息类 repository
 * @author asher
 */
@Repository
public interface ProjectInfoRepository extends BaseRepository<ProjectInfo> {

}