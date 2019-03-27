package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SysClassProperty;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 类属性配置 controller 测试
 * @author asher
 */
public class SysClassPropertyControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SysClassProperty sysClassProperty = new SysClassProperty();
        HttpEntity<SysClassProperty> httpEntity = new HttpEntity<>(sysClassProperty, httpHeaders);
        ParameterizedTypeReference<Result<SysClassProperty>> type = new ParameterizedTypeReference<Result<SysClassProperty>>() {};
        ResponseEntity<Result<SysClassProperty>> responseEntity = restTemplate.exchange("/sysClassProperty/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}