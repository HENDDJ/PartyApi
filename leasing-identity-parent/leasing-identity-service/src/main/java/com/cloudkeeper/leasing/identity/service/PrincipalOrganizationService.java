package com.cloudkeeper.leasing.identity.service;


import com.cloudkeeper.leasing.identity.domain.PrincipalOrganization;
import com.cloudkeeper.leasing.identity.dto.principalorganization.PrincipalOrganizationDTO;
import com.cloudkeeper.leasing.base.service.BaseService;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 用户组织 service
 * @author jerry
 */
public interface PrincipalOrganizationService extends BaseService<PrincipalOrganization> {

    /**
     * 查询列表 根据用户id
     * @param principalId 用户id
     * @return 用户组织关系列表
     */
    @Nonnull
    List<PrincipalOrganization> findAllByPrincipalId(@Nonnull String principalId);

    /**
     * 删除用户与组织的关系
     * @param principalId 用户id
     */
    void deleteAllByPrincipalId(@Nonnull String principalId);

    /**
     * 批量保存
     * @param principalId 用户id
     * @param principalOrganizationDTOList 用户组织关系dto集合
     * @return 用户组织关系集合
     */
    @Nonnull
    List<PrincipalOrganization> save(@Nonnull String principalId, @Nonnull List<PrincipalOrganizationDTO> principalOrganizationDTOList);

    /**
     * 查询用户主岗
     * @param principalId 用户id
     * @return 用户岗位
     */
    PrincipalOrganization findByPrincipalId(@Nonnull String principalId);

}
