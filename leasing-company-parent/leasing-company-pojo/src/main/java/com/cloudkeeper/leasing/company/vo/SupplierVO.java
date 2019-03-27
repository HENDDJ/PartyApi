package com.cloudkeeper.leasing.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 供应商 VO
 * @author asher
 */
@ApiModel(value = "供应商 VO", description = "供应商 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SupplierVO extends CommonCompanyVO {

    /** 公司父表id */
    @ApiModelProperty(value = "公司父表id", position = 1, required = true)
    private String parentId;

    /** 供应商类别 */
    @ApiModelProperty(value = "供应商类别", position = 1, required = true)
    private String category;

}