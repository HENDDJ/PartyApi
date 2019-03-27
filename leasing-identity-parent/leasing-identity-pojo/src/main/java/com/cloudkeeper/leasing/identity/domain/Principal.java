package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.PrincipalVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.persistence.*;

/**
 * 用户
 * @author jerry
 */
@ApiModel(value = "用户", description = "用户")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ck_id_principal")
public class Principal extends BaseEntity {

    /** 登录名 */
    @ApiModelProperty(value = "登录名", position = 10, required = true)
    @Column(length = 30)
    private String code;

    /** 头像 */
    @ApiModelProperty(value = "头像", position = 20)
    @Column(length = 1000)
    private String photo;

    /** 姓名 */
    @ApiModelProperty(value = "姓名", position = 12, required = true)
    @Column(length = 50)
    private String name;

    /** 密码 */
    @ApiModelProperty(value = "密码", position = 14, required = true)
    @Column(length = 50)
    private String password;

    /** 手机 */
    @ApiModelProperty(value = "手机", position = 16)
    @Column(length = 11)
    private String mobile;

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱", position = 18)
    @Column(length = 100)
    private String email;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 20)
    @Column(length = 1000)
    private String note;

    /** 组织id */
    @ApiModelProperty(value = "组织id", position = 22, required = true)
    @Column(length = 36)
    private String organizationId;

    /** 组织 */
    @ApiModelProperty(value = "组织", position = 24)
    @ManyToOne
    @JoinColumn(name = "organizationId", insertable = false, updatable = false)
    private Organization organization;

    /** 角色id */
    @ApiModelProperty(value = "角色id", position = 26, required = true)
    @Column(length = 36)
    private String roleId;

    /** 角色 */
    @ApiModelProperty(value = "角色", position = 28)
    @ManyToOne
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private Role role;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        PrincipalVO principalVO = (PrincipalVO) convert;
        if(!StringUtils.isEmpty(this.organization)){
            principalVO.setOrganizationName(this.organization.getName());
        }
        if(!StringUtils.isEmpty(this.role)){
            principalVO.setRoleName(this.role.getName());
        }

        return (T) principalVO;
    }

}
