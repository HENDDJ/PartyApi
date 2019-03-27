package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SysClass;
import com.cloudkeeper.leasing.identity.repository.SysClassRepository;
import com.cloudkeeper.leasing.identity.service.SysClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 系统java类 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysClassServiceImpl extends BaseServiceImpl<SysClass> implements SysClassService {

    /** 系统java类 repository */
    private final SysClassRepository sysClassRepository;

    @Override
    protected BaseRepository<SysClass> getBaseRepository() {
        return sysClassRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("des", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}