package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.ProjectInfo;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 工程信息类 controller 测试
 * @author asher
 */
public class ProjectInfoControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        ProjectInfo projectInfo = new ProjectInfo();
        HttpEntity<ProjectInfo> httpEntity = new HttpEntity<>(projectInfo, httpHeaders);
        ParameterizedTypeReference<Result<ProjectInfo>> type = new ParameterizedTypeReference<Result<ProjectInfo>>() {};
        ResponseEntity<Result<ProjectInfo>> responseEntity = restTemplate.exchange("/projectInfo/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}