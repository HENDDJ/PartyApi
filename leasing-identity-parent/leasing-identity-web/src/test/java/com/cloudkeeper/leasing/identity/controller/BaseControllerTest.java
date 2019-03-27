package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.WebTestConfig;
import com.cloudkeeper.leasing.identity.domain.Principal;
import com.cloudkeeper.leasing.base.constant.AuthorizationConstants;
import com.cloudkeeper.leasing.base.model.Result;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebTestConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseControllerTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    protected HttpHeaders httpHeaders;

    @Before
    public void getHttpHeaders() {
        httpHeaders = new HttpHeaders();
        ParameterizedTypeReference<Result<String>> type = new ParameterizedTypeReference<Result<String>>() {};
        Principal principal = new Principal();
        principal.setCode("admin");
        principal.setPassword("123");
        HttpEntity<Principal> httpEntity = new HttpEntity<>(principal);
        String token = restTemplate.exchange("/principal/login", HttpMethod.POST, httpEntity, type).getBody().getContent();
        httpHeaders.add(AuthorizationConstants.AUTHORIZATION, token);
    }
}
