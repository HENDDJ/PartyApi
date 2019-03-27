package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.PrincipalOrganization;
import com.cloudkeeper.leasing.identity.dto.principalorganization.PrincipalOrganizationDTO;
import com.cloudkeeper.leasing.identity.repository.PrincipalOrganizationRepository;
import com.cloudkeeper.leasing.identity.service.PrincipalOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户组织 service
 * @author jerry
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PrincipalOrganizationServiceImpl extends BaseServiceImpl<PrincipalOrganization> implements PrincipalOrganizationService {

    /** 用户组织 repository */
    private final PrincipalOrganizationRepository principalOrganizationRepository;

    @Override
    protected BaseRepository<PrincipalOrganization> getBaseRepository() {
        return principalOrganizationRepository;
    }

    @Nonnull
    @Override
    public List<PrincipalOrganization> findAllByPrincipalId(@Nonnull String principalId) {
        return principalOrganizationRepository.findAllByPrincipalIdOrderByIsPartAsc(principalId);
    }

    @Override
    public void deleteAllByPrincipalId(@Nonnull String principalId) {
        principalOrganizationRepository.deleteAllByPrincipalId(principalId);
    }

    @Nonnull
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrincipalOrganization> save(@Nonnull String principalId, @Nonnull List<PrincipalOrganizationDTO> principalOrganizationDTOList) {
        principalOrganizationRepository.deleteAllByPrincipalId(principalId);
        return principalOrganizationDTOList.stream().map(principalOrganizationDTO -> {
            PrincipalOrganization principalOrganization = principalOrganizationDTO.convert(PrincipalOrganization.class);
            principalOrganization.setPrincipalId(principalId);
            principalOrganization = principalOrganizationRepository.save(principalOrganization);
            return principalOrganization;
        }).collect(Collectors.toList());
    }

    @Override
    public PrincipalOrganization findByPrincipalId(@Nonnull String principalId) {
        return principalOrganizationRepository.findByPrincipalIdAndIsPart(principalId);
    }
}
