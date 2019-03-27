package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.Principal;
import com.cloudkeeper.leasing.identity.domain.RoleMenu;
import com.cloudkeeper.leasing.identity.domain.SysRoutes;
import com.cloudkeeper.leasing.identity.repository.RoleMenuRepository;
import com.cloudkeeper.leasing.identity.service.RoleMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 角色菜单 service
 * @author jerry
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService {

    /** 角色菜单 repository */
    private final RoleMenuRepository roleMenuRepository;

    private final PrincipalServiceImpl principalService;

    @Override
    protected BaseRepository<RoleMenu> getBaseRepository() {
        return roleMenuRepository;
    }

    @Nonnull
    @Override
    public List<RoleMenu> findAllByRoleId(@Nonnull String roleId) {
        return roleMenuRepository.findAllByRoleIdOrderByCreatedAtAsc(roleId);
    }

    @Override
    public void deleteAllByRoleId(@Nonnull String roleId) {
        roleMenuRepository.deleteAllByRoleId(roleId);
    }

    @Nonnull
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<RoleMenu> save(@Nonnull String roleId, @Nonnull List<String> menuCodeList) {
        roleMenuRepository.deleteAllByRoleId(roleId);
        return menuCodeList.stream().map(menuCode -> {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setSysRouteId(menuCode);
            return roleMenuRepository.save(roleMenu);
        }).collect(Collectors.toList());
    }

    @Nonnull
    @Override
    public List<SysRoutes> findAllMenuCodeByPrincipalId(@Nonnull String principalId) {
        Optional<Principal> optionalById = principalService.findOptionalById(principalId);
        if (!optionalById.isPresent()) {
            return new ArrayList<>();
        }
        List<RoleMenu> roleMenus = roleMenuRepository.findAllByRoleIdOrderByCreatedAtAsc(optionalById.get().getRoleId());
        ArrayList<SysRoutes> sysRoutes = roleMenus.stream().map(item -> item.getSysRoutes()).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<SysRoutes> firstMenus = sysRoutes.stream().filter(item -> item.getParentId() == null).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<SysRoutes> childMenus = sysRoutes.stream().filter(item -> item.getParentId() != null).collect(Collectors.toCollection(ArrayList::new));
        firstMenus.stream().forEach(it -> {
            it.setChildren(new ArrayList<>());
            for (SysRoutes item : childMenus) {
                if (item.getParentId().equals(it.getId())) {
                    it.getChildren().add(item);
                }
            }
        });
        Collections.sort(firstMenus);
        return firstMenus;
    }
}
