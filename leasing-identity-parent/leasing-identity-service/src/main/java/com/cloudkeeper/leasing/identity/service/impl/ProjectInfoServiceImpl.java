package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.ProjectInfo;
import com.cloudkeeper.leasing.identity.repository.ProjectInfoRepository;
import com.cloudkeeper.leasing.identity.service.ProjectInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 工程信息类 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectInfoServiceImpl extends BaseServiceImpl<ProjectInfo> implements ProjectInfoService {

    /** 工程信息类 repository */
    private final ProjectInfoRepository projectInfoRepository;

    @Override
    protected BaseRepository<ProjectInfo> getBaseRepository() {
        return projectInfoRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("number", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("longitude", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("latitude", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("department", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("responsibility", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("investment", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("licenseNumber", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("property", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("size", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("license", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sourcesFunds", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}