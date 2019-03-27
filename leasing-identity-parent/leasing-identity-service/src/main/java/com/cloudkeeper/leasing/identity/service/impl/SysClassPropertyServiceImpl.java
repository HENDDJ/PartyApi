package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SysClassProperty;
import com.cloudkeeper.leasing.identity.repository.SysClassPropertyRepository;
import com.cloudkeeper.leasing.identity.service.SysClassPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 类属性配置 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysClassPropertyServiceImpl extends BaseServiceImpl<SysClassProperty> implements SysClassPropertyService {

    /** 类属性配置 repository */
    private final SysClassPropertyRepository sysClassPropertyRepository;

    @Override
    protected BaseRepository<SysClassProperty> getBaseRepository() {
        return sysClassPropertyRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("des", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}