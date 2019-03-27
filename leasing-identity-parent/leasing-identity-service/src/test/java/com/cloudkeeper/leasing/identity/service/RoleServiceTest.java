package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RoleServiceTest {

    /** 角色 service*/
    @Autowired
    private RoleService roleService;

    @Test
    public void init() {
        Map<String, String> map = new HashMap<>();
        map.put("GENERAL_MANAGER", "总经理");
        map.put("SALESMAN_LEADER", "业务主管");
        map.put("SALESMAN", "业务员");
        map.put("FINANCIAL_LEADER", "财务主管");
        map.put("FINANCIAL", "财务");

        map.forEach((code, name) -> {
            Role role = new Role();
            role.setCode(code);
            role.setName(name);
            roleService.save(role);
        });
    }

    @Test
    public void existsCode() {

    }
}