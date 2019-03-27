package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.SysRoutes;
import com.cloudkeeper.leasing.base.service.BaseService;
import com.cloudkeeper.leasing.identity.dto.sysroutes.SysRoutesDTO;

/**
 * 类属性配置 service
 * @author asher
 */
public interface SysRoutesService extends BaseService<SysRoutes> {

    SysRoutes save(SysRoutesDTO sysRoutesDTO);
}