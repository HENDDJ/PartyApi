package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SysLoginLog;
import com.cloudkeeper.leasing.identity.repository.SysLoginLogRepository;
import com.cloudkeeper.leasing.identity.service.SysLoginLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 登录日志 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysLoginLogServiceImpl extends BaseServiceImpl<SysLoginLog> implements SysLoginLogService {

    /** 登录日志 repository */
    private final SysLoginLogRepository sysLoginLogRepository;

    @Override
    protected BaseRepository<SysLoginLog> getBaseRepository() {
        return sysLoginLogRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("success", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}