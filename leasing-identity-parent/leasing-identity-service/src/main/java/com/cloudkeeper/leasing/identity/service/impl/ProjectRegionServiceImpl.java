package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.ProjectRegion;
import com.cloudkeeper.leasing.identity.repository.ProjectRegionRepository;
import com.cloudkeeper.leasing.identity.service.ProjectRegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 小区 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectRegionServiceImpl extends BaseServiceImpl<ProjectRegion> implements ProjectRegionService {

    /** 小区 repository */
    private final ProjectRegionRepository projectRegionRepository;

    @Override
    protected BaseRepository<ProjectRegion> getBaseRepository() {
        return projectRegionRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("regionUuid", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}