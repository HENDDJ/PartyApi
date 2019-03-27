package com.cloudkeeper.leasing.company.controller;

import com.cloudkeeper.leasing.base.model.Result;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class VehicleControllerTest extends BaseControllerTest {

    @Test
    public void getTask() {
        ParameterizedTypeReference<Result<String>> type = new ParameterizedTypeReference<Result<String>>() {};
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Result<String>> responseEntity = restTemplate.exchange("/vehicles/{id}id",
                HttpMethod.PUT, httpEntity, type, "314d6b0d-402a-4631-8f21-20aca1efb461");
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        System.out.println(responseEntity.getBody().getContent());
    }
}
