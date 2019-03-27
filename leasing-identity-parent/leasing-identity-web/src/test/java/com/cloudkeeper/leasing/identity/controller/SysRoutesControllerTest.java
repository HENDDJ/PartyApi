package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SysRoutes;
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
public class SysRoutesControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SysRoutes sysRoutes = new SysRoutes();
        HttpEntity<SysRoutes> httpEntity = new HttpEntity<>(sysRoutes, httpHeaders);
        ParameterizedTypeReference<Result<SysRoutes>> type = new ParameterizedTypeReference<Result<SysRoutes>>() {};
        ResponseEntity<Result<SysRoutes>> responseEntity = restTemplate.exchange("/sysRoutes/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}