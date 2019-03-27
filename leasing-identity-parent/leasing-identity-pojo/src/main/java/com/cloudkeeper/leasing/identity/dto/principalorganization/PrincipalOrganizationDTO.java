package com.cloudkeeper.leasing.identity.dto.principalorganization;

import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户组织dto
 * @author jerry
 */
@ApiModel(value = "用户组织dto", description = "用户组织dto")
@Getter
@Setter
public class PrincipalOrganizationDTO extends BaseEditDTO {

    /** 组织id*/
    @ApiModelProperty(value = "组织id", position = 13, required = true)
    @NotBlank
    @Length(min = 36, max = 36)
    private String organizationId;

    /** 是否兼职组织（岗位）*/
    @ApiModelProperty(value = "是否兼职组织", position = 16, required = true)
    @NotNull
    private Integer isPart;
}
