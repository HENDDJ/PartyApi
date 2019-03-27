package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.SysLoginLog;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 登录日志 repository
 * @author lxw
 */
@Repository
public interface SysLoginLogRepository extends BaseRepository<SysLoginLog> {

}