package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SysLoginLog;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 登录日志 controller 测试
 * @author lxw
 */
public class SysLoginLogControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SysLoginLog sysLoginLog = new SysLoginLog();
        HttpEntity<SysLoginLog> httpEntity = new HttpEntity<>(sysLoginLog, httpHeaders);
        ParameterizedTypeReference<Result<SysLoginLog>> type = new ParameterizedTypeReference<Result<SysLoginLog>>() {};
        ResponseEntity<Result<SysLoginLog>> responseEntity = restTemplate.exchange("/sysLoginLog/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}