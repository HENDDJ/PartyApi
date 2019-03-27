package com.cloudkeeper.leasing.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 担保公司 VO
 * @author asher
 */
@ApiModel(value = "担保公司 VO", description = "担保公司 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class GuaranteeCompanyVO extends CommonCompanyVO {

    /** 公司父表id */
    @ApiModelProperty(value = "公司父表id", position = 1, required = true)
    private String parentId;

    /** 职工人数 */
    @ApiModelProperty(value = "职工人数", position = 3)
    private Integer staffNumber;

    /** 银行名称 */
    @ApiModelProperty(value = "银行名称", position = 5)
    private String bankName;

    /** 银行账户 */
    @ApiModelProperty(value = "银行账户", position = 7)
    private String bankAccount;

}