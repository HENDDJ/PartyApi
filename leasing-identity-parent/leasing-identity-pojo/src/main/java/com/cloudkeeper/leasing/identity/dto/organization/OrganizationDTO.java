package com.cloudkeeper.leasing.identity.dto.organization;

import com.cloudkeeper.leasing.identity.enumeration.OrganizationTypeEnum;
import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 组织dto
 * @author jerry
 */
@ApiModel(value = "组织dto", description = "组织dto")
@Getter
@Setter
public class OrganizationDTO extends BaseEditDTO {

    /** 编码*/
    @ApiModelProperty(value = "编码", position = 10, required = true)
    @NotBlank
    @Length(max = 24)
    private String code;

    /** 名称*/
    @ApiModelProperty(value = "名称", position = 12, required = true)
    @NotBlank
    @Length(max = 50)
    private String name;

    /** 父id*/
    @ApiModelProperty(value = "父id", position = 14)
    @Length(min = 36, max = 36)
    private String parentId;

    /** 组织类型*/
    @ApiModelProperty(value = "组织类型", position = 16, required = true)
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private OrganizationTypeEnum type;

    /** 排序*/
    @ApiModelProperty(value = "排序", position = 18, required = true)
    @NotNull
    private Integer sort;

    /** 描述*/
    @ApiModelProperty(value = "描述", position = 20)
    @Length(max = 1000)
    private String note;
}
