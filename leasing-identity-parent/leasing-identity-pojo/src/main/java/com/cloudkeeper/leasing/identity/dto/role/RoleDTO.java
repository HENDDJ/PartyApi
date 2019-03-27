package com.cloudkeeper.leasing.identity.dto.role;

import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 角色dto
 * @author jerry
 */
@ApiModel(value = "角色dto", description = "角色dto")
@Getter
@Setter
public class RoleDTO extends BaseEditDTO {

    /** 编码*/
    @ApiModelProperty(value = "编码", position = 10, required = true)
    @NotBlank
    @Length(max = 50)
    private String code;

    /** 名称*/
    @ApiModelProperty(value = "名称", position = 12, required = true)
    @NotBlank
    @Length(max = 50)
    private String name;

    /** 描述*/
    @ApiModelProperty(value = "描述", position = 14)
    @Length(max = 1000)
    private String note;

    /** 组织 id*/
    @ApiModelProperty(value = "组织id", position = 16)
    @Length(max = 36)
    private String organizationId;

}
