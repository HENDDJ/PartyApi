package com.cloudkeeper.leasing.company.dto.intentionalCustomer;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ApiModel(value = "意向客户Searchable", description = "意向客户Searchable")
public class IntentionalCustomerSearchable extends BaseSearchable {

    /** 客户名称*/
    @ApiModelProperty(value = "客户名称", position = 1)
    private String name;

    /** 统一信用代码*/
    @ApiModelProperty(value = "统一信用代码", position = 3)
    private String uniformCreditCode;

    /** 行业分类*/
    @ApiModelProperty(value = "行业分类", position = 5)
    private String industryType;

    /** 联系人*/
    @ApiModelProperty(value = "联系人", position = 7)
    private String contact;

    /** 客户区域*/
    @ApiModelProperty(value = "客户区域", position = 9)
    private String area;

    /** 联系方式*/
    @ApiModelProperty(value = "联系方式", position = 11)
    private String contactInfo;

    /** 客户等级*/
    @ApiModelProperty(value = "客户等级", position = 13)
    private String grade;

    /** 职务*/
    @ApiModelProperty(value = "职务", position = 15)
    private String post;
}
