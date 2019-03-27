package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.EnvironmentData;
import com.cloudkeeper.leasing.identity.repository.EnvironmentDataRepository;
import com.cloudkeeper.leasing.identity.service.EnvironmentDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 环境数据类 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnvironmentDataServiceImpl extends BaseServiceImpl<EnvironmentData> implements EnvironmentDataService {

    /** 环境数据类 repository */
    private final EnvironmentDataRepository environmentDataRepository;

    @Override
    protected BaseRepository<EnvironmentData> getBaseRepository() {
        return environmentDataRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("deviceName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("projectNumber", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("deviceCode", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("Pm25", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("Pm10", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("windSpeed", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("windDirection", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("windPower", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("noise", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("temperture", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("humidty", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("atmos", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("TSP", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("createTime", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}