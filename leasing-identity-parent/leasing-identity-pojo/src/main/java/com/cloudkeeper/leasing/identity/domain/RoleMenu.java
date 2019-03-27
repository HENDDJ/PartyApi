package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 角色菜单关联关系，中间表
 * @author jerry
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ck_id_role_menu")
public class RoleMenu extends BaseEntity {

    /** 角色id */
    @ApiModelProperty(value = "角色id", position = 10, required = true)
    @Column(length = 36)
    private String roleId;

    /** 角色 */
    @ApiModelProperty(value = "角色", position = 11, required = true)
    @ManyToOne
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private Role role;

    /** 菜单id */
    @ApiModelProperty(value = "菜单id", position = 13, required = true)
    @Column(length = 36)
    private String sysRouteId;

    /** 角色 */
    @ApiModelProperty(value = "菜单id", position = 15, required = true)
    @ManyToOne
    @JoinColumn(name = "sysRouteId", insertable = false, updatable = false)
    private SysRoutes sysRoutes;

}
