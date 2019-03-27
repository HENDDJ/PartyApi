package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.Principal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 默认用 h2 数据库，不需要配置
 * @AutoConfigureTestDatabase 用手动配置的数据库
 */
@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PrincipalRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PrincipalRepository principalRepository;

    @Test
    public void test001() {
        entityManager.persist(new Principal().setCode("t1"));
        Optional<Principal> principalOptional = principalRepository.findByCode("t1");
        assertThat(principalOptional).isPresent();
    }
}
