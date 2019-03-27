package com.cloudkeeper.leasing.company.dto.customer;

import com.cloudkeeper.leasing.company.dto.commoncompany.CommonCompanyDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * 客户dto
 * @author jerry
 */
@ApiModel(value = "客户dto", description = "客户dto")
@Getter
@Setter
public class CustomerDTO extends CommonCompanyDTO {

    /** 公司父表id*/
    @ApiModelProperty(value = "公司父表id", position = 1, required = true)
    @Length(max = 36)
    private String parentId;

    /** 职工人数*/
    @ApiModelProperty(value = "职工人数", position = 3)
    private Integer staffNumber;

    /** 银行名称*/
    @ApiModelProperty(value = "银行名称", position = 5)
    @Length(max = 36)
    private String bankName;

    /** 银行账户*/
    @ApiModelProperty(value = "银行账户", position = 7)
    @Length(max = 36)
    private String bankAccount;

    /** 公司电话*/
    @ApiModelProperty(value = "公司电话", position = 9)
    @Length(max = 36)
    private String phoneNumber;

    /** 工厂地址--省*/
    @ApiModelProperty(value = "工厂地址--省", position = 11)
    @Length(max = 36)
    private String factoryProvince;

    /** 工厂地址--市*/
    @ApiModelProperty(value = "工厂地址--市", position = 13)
    @Length(max = 36)
    private String factoryCity;

    /** 工厂地址--详细地址*/
    @ApiModelProperty(value = "工厂地址--详细地址", position = 15)
    @Length(max = 200)
    private String factoryDetailAddress;
}
