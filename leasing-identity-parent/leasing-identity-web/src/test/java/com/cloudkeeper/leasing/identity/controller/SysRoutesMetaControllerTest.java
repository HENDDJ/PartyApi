package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SysRoutesMeta;
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
public class SysRoutesMetaControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SysRoutesMeta sysRoutesMeta = new SysRoutesMeta();
        HttpEntity<SysRoutesMeta> httpEntity = new HttpEntity<>(sysRoutesMeta, httpHeaders);
        ParameterizedTypeReference<Result<SysRoutesMeta>> type = new ParameterizedTypeReference<Result<SysRoutesMeta>>() {};
        ResponseEntity<Result<SysRoutesMeta>> responseEntity = restTemplate.exchange("/sysRoutesMeta/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}