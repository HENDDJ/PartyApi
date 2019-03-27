package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.Role;
import com.cloudkeeper.leasing.identity.domain.RoleMenu;
import com.cloudkeeper.leasing.identity.repository.RoleRepository;
import com.cloudkeeper.leasing.identity.service.RoleMenuService;
import com.cloudkeeper.leasing.identity.service.RoleService;
import com.cloudkeeper.leasing.identity.vo.RoleMenuVO;
import com.cloudkeeper.leasing.identity.vo.RoleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 角色 service
 * @author jerry
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    /** 角色 repository */
    private final RoleRepository roleRepository;

    /** 角色菜单 service */
    private final RoleMenuService roleMenuService;

    @Override
    protected BaseRepository<Role> getBaseRepository() {
        return roleRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("code", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
    }

    @Override
    public boolean existsCode(@Nonnull String code, String id) {
        if (StringUtils.hasText(id)) {
            return roleRepository.existsByCodeAndIdNot(code, id);
        } else {
            return roleRepository.existsByCode(code);
        }
    }

    @Override
    public void loadChildrenVO(@Nonnull RoleVO roleVO) {
        List<RoleMenuVO> roleMenuVOList = RoleMenu.convert(roleMenuService.findAllByRoleId(roleVO.getId()), RoleMenuVO.class);
        roleVO.setRoleMenuVOList(roleMenuVOList);
    }
}
