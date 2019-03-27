package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.EnvironmentData;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 环境数据类 controller 测试
 * @author asher
 */
public class EnvironmentDataControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        EnvironmentData environmentData = new EnvironmentData();
        HttpEntity<EnvironmentData> httpEntity = new HttpEntity<>(environmentData, httpHeaders);
        ParameterizedTypeReference<Result<EnvironmentData>> type = new ParameterizedTypeReference<Result<EnvironmentData>>() {};
        ResponseEntity<Result<EnvironmentData>> responseEntity = restTemplate.exchange("/environmentData/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}