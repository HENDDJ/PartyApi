package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.RoleMenu;
import com.cloudkeeper.leasing.identity.repository.RoleMenuRepository;
import com.cloudkeeper.leasing.identity.service.impl.RoleMenuServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class RoleMenuServiceTest {

    /** 角色菜单 repository*/
    private RoleMenuRepository roleMenuRepository;

    /** 角色菜单 service*/
    private RoleMenuService roleMenuService;

    @Before
    public void setUp() throws Exception {
        // 对所有注解了@Mock的对象进行模拟
        // MockitoAnnotations.initMocks(this);
        // 不使用注解，可以对单个对象进行 mock
        roleMenuRepository = Mockito.mock(RoleMenuRepository.class);
        // 构造被测试对象
//        roleMenuService = new RoleMenuServiceImpl(roleMenuRepository);
        // 打桩，构建当 userRepository的 getOne 函数执行参数为 1的时候，设置返回的结果 User
        List<RoleMenu> roleMenuList = new ArrayList<>();
        roleMenuList.add((RoleMenu) new RoleMenu().setId("123"));
        Mockito.when(roleMenuRepository.findAllByRoleIdOrderByCreatedAtAsc("1")).thenReturn(roleMenuList);
        // 打桩，构建当 userRepository的 getOne 函数执行参数为 2的时候，设置返回的结果 null
        Mockito.when(roleMenuRepository.findAllByRoleIdOrderByCreatedAtAsc("2")).thenReturn(new ArrayList<>());
//        // 打桩，构建当 userRepository的 getOne 函数执行参数为 3的时候，设置结果抛出异常
//        Mockito.when(roleMenuRepository.findAllByRoleId("1")).thenThrow(new IllegalArgumentException("The id is not support"));
        // 打桩，当 userRepository.updateUser 执行任何User类型的参数，返回的结果都是true
        RoleMenu roleMenu = Mockito.any(RoleMenu.class);
        Mockito.when(roleMenuRepository.save(roleMenu)).thenReturn(roleMenu);
    }

    @Test
    public void findAllByRoleId() {
        List<RoleMenu> roleMenuList = roleMenuService.findAllByRoleId("1");
        assertThat(roleMenuList, Matchers.hasSize(1));
    }

    @Test
    public void deleteAllByRoleId() {
    }

    @Test
    public void save() {
        String roleId = "1";
        List<String> menuCodeList = Arrays.asList("a", "b", "c");
        List<RoleMenu> roleMenuList = roleMenuService.save(roleId, menuCodeList);
        System.out.println(roleMenuList);
        assertThat(roleMenuList, Matchers.hasSize(3));
    }

    @Test
    public void findAllMenuCodeByPrincipalId() {
    }
}
