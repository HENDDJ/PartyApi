package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class DocProcessControllerTest extends BaseControllerTest {

    @Test
    public void startProcess() {
        ParameterizedTypeReference<Result<String>> type = new ParameterizedTypeReference<Result<String>>() {};
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Result<String>> responseEntity = restTemplate.exchange("/process/start/{name}name", HttpMethod.POST, httpEntity, type, "doc");
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        System.out.println(responseEntity.getBody().getContent());
    }

    @Test
    public void completeTask() {
        ParameterizedTypeReference<Result<String>> type = new ParameterizedTypeReference<Result<String>>() {};
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Result<String>> responseEntity = restTemplate.exchange("/process/complete/{processInstanceId}processInstanceId",
                HttpMethod.PUT, httpEntity, type, "75001");
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        System.out.println(responseEntity.getBody().getContent());
    }
}