package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.Principal;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalLoginDTO;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalSearchable;
import com.cloudkeeper.leasing.base.model.Result;
import liquibase.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PrincipalServiceTest {

    @Autowired
    private PrincipalService principalService;

    @Test
    public void login() {
        PrincipalLoginDTO principalLoginDTO = new PrincipalLoginDTO();
        principalLoginDTO.setCode("admin");
        principalLoginDTO.setPassword("123");
        Result<String> result = principalService.login(principalLoginDTO);
        Assert.assertEquals(result.getCode(), Result.ResultCode.OK.getCode());
        log.info("token:" + result.getContent());
}

    @Test
    public void saveTest() {
        Principal principal1 = new Principal();
        principal1.setCode("jerry");
        principal1.setName("杰瑞");
        principal1.setPassword(MD5Util.computeMD5("123456"));
        principalService.save(principal1);

        Principal principal2 = new Principal();
        principal2.setCode("tom");
        principal2.setName("汤姆");
        principal2.setPassword(MD5Util.computeMD5("123456"));
        principalService.save(principal2);

        Principal principal3 = new Principal();
        principal3.setCode("ella");
        principal3.setName("艾拉");
        principal3.setPassword(MD5Util.computeMD5("123456"));
        principalService.save(principal3);

        Principal principal4 = new Principal();
        principal4.setCode("henry");
        principal4.setName("亨利");
        principal4.setPassword(MD5Util.computeMD5("123456"));
        principalService.save(principal4);
    }

    @Test
    public void existsCode() {
        assertFalse(principalService.existsCode("admin", "4f722cb9-86ff-499d-83ef-c691d0441104"));
        assertTrue(principalService.existsCode("tom", "4f722cb9-86ff-499d-83ef-c691d0441104"));
        assertTrue(principalService.existsCode("admin", ""));
        assertFalse(principalService.existsCode("admin1", ""));
    }

    @Test
    public void findAllTestSP() {
        PrincipalSearchable principalSearchable = new PrincipalSearchable();
        Pageable pageable = PageRequest.of(0, 10);
        Page<Principal> page = principalService.findAll(principalSearchable, pageable);
        System.out.println(page.getTotalElements());
    }

}