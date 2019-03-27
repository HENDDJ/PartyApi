package com.cloudkeeper.leasing.company.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 意向客户类
 */

@ApiModel(value = "意向客户类", description = "意向客户类")
@Getter
@Setter
@Entity
@Table(name = "cp_intentional_customers")
public class IntentionalCustomer extends BaseEntity {

    /** 客户名称*/
    @ApiModelProperty(value = "客户名称", position = 1, required = true)
    @Column(length = 100)
    private String name;

    /** 统一信用代码*/
    @ApiModelProperty(value = "统一信用代码", position = 3, required = true)
    @Column(length = 100)
    private String uniformCreditCode;

    /** 行业分类*/
    @ApiModelProperty(value = "行业分类", position = 5, required = true)
    @Column(length = 100)
    private String industryType;

    /** 联系人*/
    @ApiModelProperty(value = "联系人", position = 7, required = true)
    @Column(length = 100)
    private String contact;

    /** 客户区域*/
    @ApiModelProperty(value = "客户区域", position = 9)
    @Column(length = 100)
    private String area;

    /** 联系方式*/
    @ApiModelProperty(value = "联系方式", position = 11, required = true)
    @Column(length = 100)
    private String contactInfo;

    /** 客户等级*/
    @ApiModelProperty(value = "客户等级", position = 13)
    @Column(length = 100)
    private String grade;

    /** 职务*/
    @ApiModelProperty(value = "职务", position = 15)
    @Column(length = 100)
    private String post;
}
