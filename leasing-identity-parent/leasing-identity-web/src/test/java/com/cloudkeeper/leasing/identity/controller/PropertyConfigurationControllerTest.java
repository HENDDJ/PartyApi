package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.domain.PropertyConfiguration;
import com.cloudkeeper.leasing.base.model.Result;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 * @author zhuwu
 * @version V1.0
 * @since 2018/9/30
 */
public class PropertyConfigurationControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
        propertyConfiguration.setName("myproperty1015");
        propertyConfiguration.setValue("001231015");
        propertyConfiguration.setDescription("测试系统属性1015");
        HttpEntity<PropertyConfiguration> httpEntity = new HttpEntity<>(propertyConfiguration, httpHeaders);
        ParameterizedTypeReference<Result<PropertyConfiguration>> type = new ParameterizedTypeReference<Result<PropertyConfiguration>>() {};
        ResponseEntity<Result<PropertyConfiguration>> responseEntity = restTemplate.exchange("/propertyConfiguration/", HttpMethod.POST, httpEntity, type);
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void update() {
        PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
        String id = "3a32ecd1-ca28-4074-aa2b-3128df4a48ee";
        propertyConfiguration.setName("myproperty2");
        propertyConfiguration.setValue("001222");
        propertyConfiguration.setDescription("测试系统属性22");
        HttpEntity<PropertyConfiguration> httpEntity = new HttpEntity<>(propertyConfiguration, httpHeaders);
        ParameterizedTypeReference<Result<PropertyConfiguration>> type = new ParameterizedTypeReference<Result<PropertyConfiguration>>() {};
        ResponseEntity<Result<PropertyConfiguration>> responseEntity = restTemplate.exchange("/propertyConfiguration/{id}id", HttpMethod.PUT, httpEntity, type, id);
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void delete() {
        PropertyConfiguration propertyConfiguration = new PropertyConfiguration();
        String id = "90eaea05-2f0f-4c70-9a2a-61db4dfdfff3";
        HttpEntity<PropertyConfiguration> httpEntity = new HttpEntity<>(propertyConfiguration, httpHeaders);
        ParameterizedTypeReference<Result<PropertyConfiguration>> type = new ParameterizedTypeReference<Result<PropertyConfiguration>>() {};
        ResponseEntity<Result<PropertyConfiguration>> responseEntity = restTemplate.exchange("/propertyConfiguration/{id}id", HttpMethod.DELETE, httpEntity, type, id);
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getBody());
    }
}
