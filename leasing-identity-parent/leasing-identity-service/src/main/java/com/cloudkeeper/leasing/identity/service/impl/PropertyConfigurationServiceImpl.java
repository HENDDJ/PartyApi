package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.PropertyConfiguration;
import com.cloudkeeper.leasing.identity.repository.PropertyConfigurationRepository;
import com.cloudkeeper.leasing.identity.service.PropertyConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 系统属性 service
 * @author zhuwu
 * @version V1.0
 * @since 2018/9/30
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PropertyConfigurationServiceImpl extends BaseServiceImpl<PropertyConfiguration> implements PropertyConfigurationService {

    /** 系统属性 repository */
    private final PropertyConfigurationRepository propertyConfigurationRepository;

    @Override
    protected BaseRepository<PropertyConfiguration> getBaseRepository() {
        return propertyConfigurationRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}
