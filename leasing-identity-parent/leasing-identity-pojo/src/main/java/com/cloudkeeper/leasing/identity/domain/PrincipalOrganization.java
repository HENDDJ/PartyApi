package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.base.enumeration.BooleanEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 用户组织关联关系，中间表
 * @author jerry
 */
@ApiModel(value = "用户组织", description = "用户组织")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ck_id_principal_organization")
public class PrincipalOrganization extends BaseEntity {

    /** 用户id */
    @ApiModelProperty(value = "用户id", position = 10, required = true)
    @Column(length = 36)
    private String principalId;

    /** 用户 */
    @ApiModelProperty(value = "用户", position = 11)
    @ManyToOne
    @JoinColumn(name = "principalId", insertable = false, updatable = false)
    private Principal principal;

    /** 组织id */
    @ApiModelProperty(value = "组织id", position = 13, required = true)
    @Column(length = 36)
    private String organizationId;

    /** 组织 */
    @ApiModelProperty(value = "组织", position = 14)
    @ManyToOne
    @JoinColumn(name = "organizationId", insertable = false, updatable = false)
    private Organization organization;

    /** 是否兼职组织（岗位） */
    @ApiModelProperty(value = "是否兼职组织", position = 16, required = true)
    private Integer isPart = BooleanEnum.FALSE.ordinal();
}
