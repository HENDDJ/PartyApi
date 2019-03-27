package com.cloudkeeper.leasing.process.controller;

import com.cloudkeeper.leasing.WebTestConfig;
import com.cloudkeeper.leasing.base.constant.AuthorizationConstants;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebTestConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseControllerTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    /** redis 数据库操作模板类*/
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    protected HttpHeaders httpHeaders;

    @Before
    public void getHttpHeaders() {
        String principalId = "4f722cb9-86ff-499d-83ef-c691d0441104";
        String token = redisTemplate.opsForValue().get(AuthorizationConstants.REDIS_TOKEN_KEY + principalId);
        httpHeaders = new HttpHeaders();
        httpHeaders.add(AuthorizationConstants.AUTHORIZATION, token);
    }
}
