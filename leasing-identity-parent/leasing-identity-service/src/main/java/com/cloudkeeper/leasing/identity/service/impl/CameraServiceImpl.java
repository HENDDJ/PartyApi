package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.Camera;
import com.cloudkeeper.leasing.identity.repository.CameraRepository;
import com.cloudkeeper.leasing.identity.service.CameraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 监控 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CameraServiceImpl extends BaseServiceImpl<Camera> implements CameraService {

    /** 监控 repository */
    private final CameraRepository cameraRepository;

    @Override
    protected BaseRepository<Camera> getBaseRepository() {
        return cameraRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("pid", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("cameraUuid", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("regionUuid", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("cameraName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("nickName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("keyBoardCode", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("rtspURL", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}