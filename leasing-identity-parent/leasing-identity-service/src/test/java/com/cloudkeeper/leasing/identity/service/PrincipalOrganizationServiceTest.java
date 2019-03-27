package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.dto.principalorganization.PrincipalOrganizationDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PrincipalOrganizationServiceTest {

    /** 用户组织 service*/
    @Autowired
    private PrincipalOrganizationService principalOrganizationService;

    @Test
    public void findAllByPrincipalId() {
    }

    @Test
    public void deleteAllByPrincipalId() {
    }

    @Test
    public void save() {
        String principalId = "63f62360-0ce4-43b8-9f61-201a2817e950";
        List<PrincipalOrganizationDTO> principalOrganizationDTOList = new ArrayList<>();
        PrincipalOrganizationDTO principalOrganizationDTO1 = new PrincipalOrganizationDTO();
        principalOrganizationDTO1.setOrganizationId("eb4c3872-bd67-433b-ba23-94b66c56ede7");
        principalOrganizationDTO1.setIsPart(0);
        PrincipalOrganizationDTO principalOrganizationDTO2 = new PrincipalOrganizationDTO();
        principalOrganizationDTO2.setOrganizationId("d77c6209-3773-4577-8689-308acb398304");
        principalOrganizationDTO2.setIsPart(1);
        principalOrganizationDTOList.add(principalOrganizationDTO1);
        principalOrganizationDTOList.add(principalOrganizationDTO2);
        principalOrganizationService.save(principalId, principalOrganizationDTOList);
    }
}