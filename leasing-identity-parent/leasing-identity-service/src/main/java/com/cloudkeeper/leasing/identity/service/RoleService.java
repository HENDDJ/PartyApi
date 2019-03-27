package com.cloudkeeper.leasing.identity.service;


import com.cloudkeeper.leasing.identity.domain.Role;
import com.cloudkeeper.leasing.identity.vo.RoleVO;
import com.cloudkeeper.leasing.base.service.BaseService;

import javax.annotation.Nonnull;

/**
 * 角色 service
 * @author jerry
 */
public interface RoleService extends BaseService<Role> {

    /**
     * 是否存在
     * @param code 编码
     * @param id 主键
     * @return true 存在
     */
    boolean existsCode(@Nonnull String code, String id);

    /**
     * 加载 子类vo数据
     * @param roleVO 角色vo
     */
    void loadChildrenVO(@Nonnull RoleVO roleVO);

}
