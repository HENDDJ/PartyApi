package com.cloudkeeper.leasing.identity.dto.propertyconfiguration;

import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author zhuwu
 * @version V1.0
 * @since 2018/9/30
 */
@ApiModel(value = "系统属性dto", description = "系统属性dto")
@Getter
@Setter
public class PropertyConfigurationDTO extends BaseEditDTO {

    /** 属性名称*/
    @ApiModelProperty(value = "属性名称", position = 10, required = true)
    @NotBlank
    @Length(max = 50)
    private String name;

    /** 属性值*/
    @ApiModelProperty(value = "属性值", position = 12, required = true)
    @NotBlank
    @Length(max = 50)
    private String value;

    /** 属性说明*/
    @ApiModelProperty(value = "属性说明", position = 14, required = true)
    @NotBlank
    @Length(max = 50)
    private String description;
}
