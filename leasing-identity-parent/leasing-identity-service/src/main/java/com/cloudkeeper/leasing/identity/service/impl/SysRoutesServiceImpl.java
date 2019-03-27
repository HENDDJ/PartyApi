package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SysRoutes;
import com.cloudkeeper.leasing.identity.domain.SysRoutesMeta;
import com.cloudkeeper.leasing.identity.dto.sysroutes.SysRoutesDTO;
import com.cloudkeeper.leasing.identity.dto.sysroutesmeta.SysRoutesMetaDTO;
import com.cloudkeeper.leasing.identity.repository.SysRoutesRepository;
import com.cloudkeeper.leasing.identity.service.SysClassService;
import com.cloudkeeper.leasing.identity.service.SysRoutesMetaService;
import com.cloudkeeper.leasing.identity.service.SysRoutesService;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.util.List;

/**
 * 类属性配置 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysRoutesServiceImpl extends BaseServiceImpl<SysRoutes> implements SysRoutesService {

    /** 类属性配置 repository */
    private final SysRoutesRepository sysRoutesRepository;


    @Autowired
    private SysClassService sysClassService;

    @Autowired
    private SysRoutesMetaService sysRoutesMetaService;

    @Override
    protected BaseRepository<SysRoutes> getBaseRepository() {
        return sysRoutesRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("path", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("component", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("des", ExampleMatcher.GenericPropertyMatchers.contains());
    }

    @Nonnull
    @Override
    public List<SysRoutes> findAll(@Nonnull DetachedCriteria detachedCriteria) {
        List<SysRoutes> all = super.findAll(detachedCriteria);
        all.forEach(item -> {
            item.getSysClass().getProperties().forEach( sysClassProperty -> {
                if ("1".equals(sysClassProperty.getIsObject())) {
                    sysClassProperty.setObj(sysClassService.getOne(sysClassProperty.getObjectId()));
                }
            });
        });
        return all;
    }

    @Override
    @Transactional
    public SysRoutes save(SysRoutesDTO sysRoutesDTO) {
        SysRoutes sysRoutes = save(sysRoutesDTO.convert(SysRoutes.class));
        SysRoutesMetaDTO meta = sysRoutesDTO.getMeta();
        meta.setRouteId(sysRoutes.getId());
        sysRoutesMetaService.save(meta.convert(SysRoutesMeta.class));
        return sysRoutes;
    }

    @Override
    public void deleteById(String id) {
        SysRoutes sysRoutes = getOne(id);
        if (sysRoutes == null) {
            return;
        }
        sysRoutesMetaService.deleteById(sysRoutes.getMeta().getId());
        super.deleteById(id);
    }

}