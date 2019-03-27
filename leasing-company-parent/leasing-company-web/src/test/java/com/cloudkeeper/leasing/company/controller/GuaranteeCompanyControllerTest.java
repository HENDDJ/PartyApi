package com.cloudkeeper.leasing.company.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.company.domain.GuaranteeCompany;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 担保公司 controller 测试
 * @author asher
 */
public class GuaranteeCompanyControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        GuaranteeCompany guaranteeCompany = new GuaranteeCompany();
        HttpEntity<GuaranteeCompany> httpEntity = new HttpEntity<>(guaranteeCompany, httpHeaders);
        ParameterizedTypeReference<Result<GuaranteeCompany>> type = new ParameterizedTypeReference<Result<GuaranteeCompany>>() {};
        ResponseEntity<Result<GuaranteeCompany>> responseEntity = restTemplate.exchange("/guaranteeCompany/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}