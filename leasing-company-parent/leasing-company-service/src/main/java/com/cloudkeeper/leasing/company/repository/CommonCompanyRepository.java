package com.cloudkeeper.leasing.company.repository;

import com.cloudkeeper.leasing.company.domain.CommonCompany;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 客户、担保公司、供应商父表 repository
 * @author asher
 */
@Repository
public interface CommonCompanyRepository extends BaseRepository<CommonCompany> {

}