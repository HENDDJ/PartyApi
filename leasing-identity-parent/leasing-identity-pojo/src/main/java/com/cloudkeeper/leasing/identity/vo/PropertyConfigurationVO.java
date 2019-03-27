package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统属性VO
 * @author zhuwu
 * @version V1.0
 */
@ApiModel(value = "系统属性vo", description = "系统属性vo")
@Getter
@Setter
public class PropertyConfigurationVO extends BaseVO {

    /** 属性名称*/
    @ApiModelProperty(value = "属性名称", position = 10, required = true)
    private String name;

    /** 属性值*/
    @ApiModelProperty(value = "属性值", position = 12, required = true)
    private String value;

    /** 属性说明*/
    @ApiModelProperty(value = "属性说明", position = 14, required = true)
    private String description;
}
