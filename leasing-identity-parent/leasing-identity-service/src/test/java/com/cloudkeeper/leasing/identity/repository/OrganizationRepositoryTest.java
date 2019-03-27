package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.Organization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrganizationRepositoryTest {

    /** 组织repository*/
    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    public void saveTest() {
        Organization organization = new Organization();
        organization.setCode("root");
        organization.setName("新光租赁");
        organization = organizationRepository.save(organization);
        System.out.println(organization);
        System.out.println(organization.getId());
        assertNotNull(organization.getId());
    }

}