package com.cloudkeeper.leasing.identity.service;


import com.cloudkeeper.leasing.identity.domain.Organization;
import com.cloudkeeper.leasing.identity.vo.OrganizationVO;
import com.cloudkeeper.leasing.base.service.BaseService;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 组织 service
 * @author jerry
 */
public interface OrganizationService extends BaseService<Organization> {

    /**
     * 根据code，查询组织
     * @param code 编码
     * @return 组织
     */
    Organization findByCode(@Nonnull String code);

    /**
     * 获取组织树
     * @return 组织树
     */
    OrganizationVO findTree();

    /**
     * 根据id，查询子节点
     * @param parentId 父节点id
     * @return 组织
     */
    @Nonnull
    List<Organization> findAllByParentId(@Nonnull String parentId);

    /**
     * 组织编码，是否存在
     * @param code 编码
     * @param parentId 父id
     * @param id id
     * @return true 存在
     */
    boolean existsCode(@Nonnull String code, @Nonnull String parentId, String id);

    /**
     * 加载 子类vo数据
     * @param organizationVO 组织vo
     */
    void loadChildrenVO(@Nonnull OrganizationVO organizationVO);
}
