package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.Accessory;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 系统附件 controller 测试
 * @author asher
 */
public class AccessoryControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        Accessory accessory = new Accessory();
        HttpEntity<Accessory> httpEntity = new HttpEntity<>(accessory, httpHeaders);
        ParameterizedTypeReference<Result<Accessory>> type = new ParameterizedTypeReference<Result<Accessory>>() {};
        ResponseEntity<Result<Accessory>> responseEntity = restTemplate.exchange("/accessory/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}