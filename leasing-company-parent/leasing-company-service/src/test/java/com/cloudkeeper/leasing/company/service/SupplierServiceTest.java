package com.cloudkeeper.leasing.company.service;

import com.cloudkeeper.leasing.company.domain.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 供应商 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SupplierServiceTest {

    /** 供应商 service */
    @Autowired
    private SupplierService supplierService;

    @Test
    public void saveTest() {
        Supplier supplier = new Supplier();
        supplier = supplierService.save(supplier);
        assertNotNull(supplier.getId());
    }

}