package com.cloudkeeper.leasing.identity.service;


import com.cloudkeeper.leasing.identity.domain.Principal;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalLoginDTO;
import com.cloudkeeper.leasing.identity.vo.PrincipalVO;
import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.base.service.BaseService;

import javax.annotation.Nonnull;

/**
 * 用户 service
 * @author jerry
 */
public interface PrincipalService extends BaseService<Principal> {

    /**
     * 登录
     * @param principalLoginDTO 用户登录dto
     * @return 返回结果
     */
    Result<String> login(@Nonnull PrincipalLoginDTO principalLoginDTO);

    /**
     * 是否存在
     * @param code 编码
     * @param id 主键
     * @return true 存在
     */
    boolean existsCode(@Nonnull String code, String id);

    /**
     * 更新逻辑删除
     * @param id 主键
     * @param isDelete 是否删除
     * @return 修改结果
     */
    Principal updateIsDelete(@Nonnull String id, @Nonnull Integer isDelete);

    /**
     * 加载 子类vo数据
     * @param principalVO 用户vo
     */
    void loadChildrenVO(@Nonnull PrincipalVO principalVO);

}
