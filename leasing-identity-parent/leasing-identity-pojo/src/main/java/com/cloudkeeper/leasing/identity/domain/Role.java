package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.RoleVO;
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
 * 角色
 * @author jerry
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ck_id_role")
public class Role extends BaseEntity {

    /** 编码 */
    @ApiModelProperty(value = "编码", position = 10, required = true)
    @Column(length = 50)
    private String code;

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 12, required = true)
    @Column(length = 50)
    private String name;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 14)
    @Column(length = 1000)
    private String note;

    /** 组织id */
    @ApiModelProperty(value = "组织id", position = 16, required = true)
    @Column(length = 36)
    private String organizationId;

    /** 组织 */
    @ApiModelProperty(value = "组织", position = 18)
    @ManyToOne
    @JoinColumn(name = "organizationId", insertable = false, updatable = false)
    private Organization organization;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        RoleVO roleVO = (RoleVO) convert;
        if(!StringUtils.isEmpty(this.organization)){
            roleVO.setOrganizationName(this.organization.getName());
        }
        return (T) roleVO;
    }

}
