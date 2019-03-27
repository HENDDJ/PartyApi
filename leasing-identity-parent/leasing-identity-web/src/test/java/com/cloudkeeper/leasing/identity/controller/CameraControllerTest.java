package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.Camera;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 监控 controller 测试
 * @author asher
 */
public class CameraControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        Camera camera = new Camera();
        HttpEntity<Camera> httpEntity = new HttpEntity<>(camera, httpHeaders);
        ParameterizedTypeReference<Result<Camera>> type = new ParameterizedTypeReference<Result<Camera>>() {};
        ResponseEntity<Result<Camera>> responseEntity = restTemplate.exchange("/camera/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}