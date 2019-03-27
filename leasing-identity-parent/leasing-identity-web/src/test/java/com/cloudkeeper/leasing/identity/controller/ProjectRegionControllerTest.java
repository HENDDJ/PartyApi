package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.ProjectRegion;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 小区 controller 测试
 * @author asher
 */
public class ProjectRegionControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        ProjectRegion projectRegion = new ProjectRegion();
        HttpEntity<ProjectRegion> httpEntity = new HttpEntity<>(projectRegion, httpHeaders);
        ParameterizedTypeReference<Result<ProjectRegion>> type = new ParameterizedTypeReference<Result<ProjectRegion>>() {};
        ResponseEntity<Result<ProjectRegion>> responseEntity = restTemplate.exchange("/projectRegion/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}