package com.cloudkeeper.leasing.identity.dto.organizationrole;

import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 组织角色dto
 * @author jerry
 */
@ApiModel(value = "组织角色dto", description = "组织角色dto")
@Getter
@Setter
public class OrganizationRoleDTO extends BaseEditDTO {

    /** 角色id*/
    @ApiModelProperty(value = "角色id", position = 13, required = true)
    @NotBlank
    @Length(min = 36, max = 36)
    private String roleId;

}
