package com.cloudkeeper.leasing.company.repository;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.company.domain.Customer;
import org.springframework.stereotype.Repository;

/**
 * 组织 repository
 * @author jerry
 */
@Repository
public interface CustomerRepository extends BaseRepository<Customer> {

}
