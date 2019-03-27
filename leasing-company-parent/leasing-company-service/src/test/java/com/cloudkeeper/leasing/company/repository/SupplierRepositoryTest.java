package com.cloudkeeper.leasing.company.repository;

import com.cloudkeeper.leasing.company.domain.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 供应商 repository 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SupplierRepositoryTest {

    /** 供应商 repository */
    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    public void saveTest() {
        Supplier supplier = new Supplier();
        supplier = supplierRepository.save(supplier);
        assertNotNull(supplier.getId());
    }

}