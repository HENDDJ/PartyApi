package com.cloudkeeper.leasing.company.dto.supplier;

import com.cloudkeeper.leasing.company.dto.commoncompany.CommonCompanyDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 供应商 DTO
 * @author asher
 */
@ApiModel(value = "供应商 DTO", description = "供应商 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO extends CommonCompanyDTO {

    /** 公司父表id */
    @ApiModelProperty(value = "公司父表id", position = 1, required = true)
    private String parentId;

    /** 供应商类别 */
    @ApiModelProperty(value = "供应商类别", position = 1, required = true)
    private String category;

}