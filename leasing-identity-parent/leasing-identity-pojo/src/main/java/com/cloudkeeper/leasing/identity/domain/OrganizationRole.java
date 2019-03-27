package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 组织角色关联关系，中间表
 * @author jerry
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ck_id_organization_role")
public class OrganizationRole extends BaseEntity {

    /** 组织id */
    @ApiModelProperty(value = "组织id", position = 10, required = true)
    @Column(length = 36)
    private String organizationId;

    /** 组织 */
    @ApiModelProperty(value = "组织", position = 11)
    @ManyToOne
    @JoinColumn(name = "organizationId", insertable = false, updatable = false)
    private Organization organization;

    /** 角色id */
    @ApiModelProperty(value = "角色id", position = 13, required = true)
    @Column(length = 36)
    private String roleId;

    /** 角色 */
    @ApiModelProperty(value = "角色", position = 14)
    @ManyToOne
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private Role role;
}
