package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SysRoutesMeta;
import com.cloudkeeper.leasing.identity.repository.SysRoutesMetaRepository;
import com.cloudkeeper.leasing.identity.service.SysRoutesMetaService;
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
public class SysRoutesMetaServiceImpl extends BaseServiceImpl<SysRoutesMeta> implements SysRoutesMetaService {

    /** 类属性配置 repository */
    private final SysRoutesMetaRepository sysRoutesMetaRepository;

    @Override
    protected BaseRepository<SysRoutesMeta> getBaseRepository() {
        return sysRoutesMetaRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("icon", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}