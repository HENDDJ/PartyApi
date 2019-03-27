package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.OrganizationRole;
import com.cloudkeeper.leasing.identity.dto.organizationrole.OrganizationRoleDTO;
import com.cloudkeeper.leasing.identity.repository.OrganizationRoleRepository;
import com.cloudkeeper.leasing.identity.service.OrganizationRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 组织角色 service
 * @author jerry
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationRoleServiceImpl extends BaseServiceImpl<OrganizationRole> implements OrganizationRoleService {

    /** 组织角色 repository */
    private final OrganizationRoleRepository principalOrganizationRepository;

    @Override
    protected BaseRepository<OrganizationRole> getBaseRepository() {
        return principalOrganizationRepository;
    }

    @Nonnull
    @Override
    public List<OrganizationRole> findAllByOrganizationId(@Nonnull String organizationId) {
        return principalOrganizationRepository.findAllByOrganizationId(organizationId);
    }

    @Override
    public void deleteAllByOrganizationId(@Nonnull String organizationId) {
        principalOrganizationRepository.deleteAllByOrganizationId(organizationId);
    }

    @Nonnull
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<OrganizationRole> save(@Nonnull String organizationId, @Nonnull List<OrganizationRoleDTO> organizationRoleDTOList) {
        principalOrganizationRepository.deleteAllByOrganizationId(organizationId);
        return organizationRoleDTOList.stream().map(organizationRoleDTO -> {
            OrganizationRole organizationRole = organizationRoleDTO.convert(OrganizationRole.class);
            organizationRole.setOrganizationId(organizationId);
            organizationRole = principalOrganizationRepository.save(organizationRole);
            return organizationRole;
        }).collect(Collectors.toList());
    }
}
