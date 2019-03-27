package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SysClass;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 系统java类 controller 测试
 * @author asher
 */
public class SysClassControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SysClass sysClass = new SysClass();
        HttpEntity<SysClass> httpEntity = new HttpEntity<>(sysClass, httpHeaders);
        ParameterizedTypeReference<Result<SysClass>> type = new ParameterizedTypeReference<Result<SysClass>>() {};
        ResponseEntity<Result<SysClass>> responseEntity = restTemplate.exchange("/sysClass/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}