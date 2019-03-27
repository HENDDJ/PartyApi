package com.cloudkeeper.leasing.company.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.domain.Supplier;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 供应商 controller 测试
 * @author asher
 */
public class SupplierControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        Supplier supplier = new Supplier();
        HttpEntity<Supplier> httpEntity = new HttpEntity<>(supplier, httpHeaders);
        ParameterizedTypeReference<Result<Supplier>> type = new ParameterizedTypeReference<Result<Supplier>>() {};
        ResponseEntity<Result<Supplier>> responseEntity = restTemplate.exchange("/supplier/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}