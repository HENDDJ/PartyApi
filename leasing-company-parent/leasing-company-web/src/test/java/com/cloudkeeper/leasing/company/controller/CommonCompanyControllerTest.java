package com.cloudkeeper.leasing.company.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.domain.CommonCompany;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 客户、担保公司、供应商父表 controller 测试
 * @author asher
 */
public class CommonCompanyControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        CommonCompany commonCompany = new CommonCompany();
        HttpEntity<CommonCompany> httpEntity = new HttpEntity<>(commonCompany, httpHeaders);
        ParameterizedTypeReference<Result<CommonCompany>> type = new ParameterizedTypeReference<Result<CommonCompany>>() {};
        ResponseEntity<Result<CommonCompany>> responseEntity = restTemplate.exchange("/commonCompany/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}