package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.domain.Principal;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalSearchable;
import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.base.utils.RestPageImpl;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class PrincipalControllerTest extends BaseControllerTest {

    @Test
    public void findOne() {
        String id = "0141db9c-16b4-490b-9fb5-42916ffdc67d";
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        ParameterizedTypeReference<Result<Principal>> type = new ParameterizedTypeReference<Result<Principal>>() {};
        ResponseEntity<Result<Principal>> responseEntity = restTemplate.exchange("/principal/{id}id", HttpMethod.GET, httpEntity, type, id);

        assert responseEntity.getStatusCodeValue() == 200;
        Principal principal = responseEntity.getBody().getContent();
        assert principal != null;
    }

    @Test
    public void login() {
        ParameterizedTypeReference<Result<String>> type = new ParameterizedTypeReference<Result<String>>() {};
        Principal principal = new Principal();
        principal.setCode("admin");
        principal.setPassword("123");
        HttpEntity<Principal> httpEntity = new HttpEntity<>(principal);
        ResponseEntity<Result<String>> responseEntity = restTemplate.exchange("/principal/login", HttpMethod.POST, httpEntity, type);
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void add() {
        Principal principal = new Principal();
        principal.setCode("jerry001");
        principal.setPassword("123");
        HttpEntity<Principal> httpEntity = new HttpEntity<>(principal, httpHeaders);
        ParameterizedTypeReference<Result<Principal>> type = new ParameterizedTypeReference<Result<Principal>>() {};
        ResponseEntity<Result<Principal>> responseEntity = restTemplate.exchange("/principal/add", HttpMethod.POST, httpEntity, type);
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void update() {
    }

    @Test
    public void page() {
        Principal principal = new Principal();
        principal.setCode("jerry001");
        principal.setPassword("123");
        HttpEntity<Principal> httpEntity = new HttpEntity<>(principal, httpHeaders);
        ParameterizedTypeReference<Result<RestPageImpl<Principal>>> type = new ParameterizedTypeReference<Result<RestPageImpl<Principal>>>() {};
        URI uri = UriComponentsBuilder.fromUriString("/principal/page").queryParam("sort", "code,asc").build().toUri();
        ResponseEntity<Result<RestPageImpl<Principal>>> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, type);
        assert responseEntity.getStatusCodeValue() == 200;
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void pagesp() {
        PrincipalSearchable principalSearchable = new PrincipalSearchable();
        HttpEntity<PrincipalSearchable> httpEntity = new HttpEntity<>(principalSearchable, httpHeaders);
        ParameterizedTypeReference<Result<RestPageImpl<Principal>>> type = new ParameterizedTypeReference<Result<RestPageImpl<Principal>>>() {};
        URI uri = UriComponentsBuilder.fromUriString("/principal/page/rootorganizationFullCode").queryParam("sort", "code,asc").build().toUri();
        ResponseEntity<Result<RestPageImpl<Principal>>> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, type);
        assert responseEntity.getStatusCodeValue() == 200;
        System.out.println(responseEntity.getBody());
    }

}