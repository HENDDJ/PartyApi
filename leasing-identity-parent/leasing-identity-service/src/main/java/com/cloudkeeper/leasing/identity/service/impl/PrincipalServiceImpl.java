package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.constant.AuthorizationConstants;
import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import com.cloudkeeper.leasing.base.enumeration.BooleanEnum;
import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.base.utils.TokenUtil;
import com.cloudkeeper.leasing.identity.domain.Principal;
import com.cloudkeeper.leasing.identity.domain.PrincipalOrganization;
import com.cloudkeeper.leasing.identity.domain.SysLoginLog;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalLoginDTO;
import com.cloudkeeper.leasing.identity.dto.principal.PrincipalSearchable;
import com.cloudkeeper.leasing.identity.dto.sysloginlog.SysLoginLogDTO;
import com.cloudkeeper.leasing.identity.repository.PrincipalRepository;
import com.cloudkeeper.leasing.identity.service.*;
import com.cloudkeeper.leasing.identity.vo.OrganizationVO;
import com.cloudkeeper.leasing.identity.vo.PrincipalVO;
import io.swagger.annotations.ApiParam;
import liquibase.util.MD5Util;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import  java.util.*;
import java.util.Date;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.time.*;

/**
 * 用户 service
 * @author jerry
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PrincipalServiceImpl extends BaseServiceImpl<Principal> implements PrincipalService {

    /** 用户 repository */
    private final PrincipalRepository principalRepository;

    /** 用户组织 service */
    private final PrincipalOrganizationService principalOrganizationService;

    /** 组织 service */
//    private final OrganizationService organizationService;

    /** 角色组织 service */
//    private final RoleMenuService roleMenuService;

    /** redis 操作 */
    private final RedisTemplate<String, String> redisTemplate;

    /** 登录日志 */
    private final SysLoginLogService sysLoginLogService;

    @Override
    protected BaseRepository<Principal> getBaseRepository() {
        return principalRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("code", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
    }

    @Override
    public Result<String> login(@Nonnull PrincipalLoginDTO principalLoginDTO) {
        Optional<Principal> principalOptional = principalRepository.findByCode(principalLoginDTO.getCode());
        if (!principalOptional.isPresent()) {
            return Result.of(Result.ResultCode.LOGIN_FAIL.getCode(), "用户名或密码错误！");
        }
        Principal principal = principalOptional.get();
        if (!principal.getPassword().equals(MD5Util.computeMD5(principalLoginDTO.getPassword()))) {
            saveLog("用户名或密码错误", principal);
            return Result.of(Result.ResultCode.LOGIN_FAIL.getCode(), "用户名或密码错误！");
        }
        if (BooleanEnum.TRUE.ordinal() == principal.getIsDelete()) {
            saveLog("用户名已被禁用", principal);
            return Result.of(Result.ResultCode.LOGIN_FAIL.getCode(), "用户名已被禁用！");
        }
        String token = TokenUtil.of(principal.getId());
        redisTemplate.opsForValue().set(AuthorizationConstants.REDIS_TOKEN_KEY + principal.getId(), token, TokenUtil.TTL_MILLIS, TimeUnit.MILLISECONDS);
        saveLog("成功", principal);
        return Result.of("登录成功！", token + "$" + principal.getId());
    }

    private void saveLog(String msg, Principal principal) {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUserId(principal.getId());
        sysLoginLog.setUserName(principal.getName());
        sysLoginLog.setLoginTime(LocalDateTime.now());
        sysLoginLog.setSuccess(msg);
        sysLoginLogService.save(sysLoginLog);
    }

    @Override
    public boolean existsCode(@Nonnull String code, String id) {
        if (StringUtils.hasText(id)) {
            return principalRepository.existsByCodeAndIdNot(code, id);
        } else {
            return principalRepository.existsByCode(code);
        }
    }

    @Override
    public Principal updateIsDelete(@Nonnull String id, @Nonnull Integer isDelete) {
        Optional<Principal> principalOptional = principalRepository.findById(id);
        if (!principalOptional.isPresent()) {
            return null;
        }
        Principal principal = principalOptional.get();
        principal.setIsDelete(isDelete);
        return principalRepository.save(principal);
    }

    @Nonnull
    @Override
    public Page<Principal> findAll(@Nonnull BaseSearchable searchable, @Nonnull Pageable pageable) {
        PrincipalSearchable principalSearchable = (PrincipalSearchable) searchable;
        // FIXME: 2018/9/26 0026 查询方式修改
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Principal.class);
        if (StringUtils.hasText(principalSearchable.getCode())) {
            detachedCriteria.add(Restrictions.like("code", principalSearchable.getCode(), MatchMode.ANYWHERE));
        }
        if (StringUtils.hasText(principalSearchable.getName())) {
            detachedCriteria.add(Restrictions.like("name", principalSearchable.getName(), MatchMode.ANYWHERE));
        }
        if (StringUtils.hasText(principalSearchable.getOrganizationCode())) {
            String sql = " exists(select 'X' from ck_id_principal_organization cipo" +
                    " left join ck_id_organization cio on cio.id = cipo.organizationId" +
                    " where cipo.principalId = {alias}.id" +
                    " and cio.fullCode like '%" + principalSearchable.getOrganizationCode() + "%')";
            detachedCriteria.add(Restrictions.sqlRestriction(sql));
        }
        detachedCriteria.add(Restrictions.eq("isDelete", principalSearchable.getIsDelete()));
        pageable.getSort().forEach(order -> detachedCriteria.addOrder(order.getDirection().isAscending() ? Order.asc(order.getProperty()) : Order.desc(order.getProperty())));
        return findAll(detachedCriteria, pageable);
    }

    @Override
    public void loadChildrenVO(@Nonnull PrincipalVO principalVO) {
        // 主岗
        PrincipalOrganization principalOrganization = principalOrganizationService.findByPrincipalId(principalVO.getId());
        if (principalOrganization != null) {
            OrganizationVO organizationVO = principalOrganization.getOrganization().convert(OrganizationVO.class);
//            organizationService.loadChildrenVO(organizationVO);
            principalVO.setOrganizationVO(organizationVO);
        }
        // 兼职岗
        List<OrganizationVO> organizationVOList = principalOrganizationService.findAllByPrincipalId(principalVO.getId())
                .stream()
                .filter(principalOrganization1 -> principalOrganization1.getIsPart() == BooleanEnum.TRUE.ordinal())
                .map(principalOrganization1 -> {
                    OrganizationVO organizationVO = principalOrganization1.getOrganization().convert(OrganizationVO.class);
//                    organizationService.loadChildrenVO(organizationVO);
                    return organizationVO;
                })
                .collect(Collectors.toList());
        principalVO.setOrganizationVOList(organizationVOList);
        // 菜单
//        List<String> menuCodeList = roleMenuService.findAllMenuCodeByPrincipalId(principalVO.getId());
//        principalVO.setMenuCodeList(menuCodeList);
    }
}
