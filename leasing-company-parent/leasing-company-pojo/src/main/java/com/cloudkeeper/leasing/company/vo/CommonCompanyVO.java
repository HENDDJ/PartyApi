package com.cloudkeeper.leasing.company.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 客户、担保公司、供应商父表 VO
 * @author asher
 */
@ApiModel(value = "客户、担保公司、供应商父表 VO", description = "客户、担保公司、供应商父表 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class CommonCompanyVO extends BaseVO {

    /** 外键至意向客户表*/
    @ApiModelProperty(value = "外键至意向客户表", position = 1)
    private String intentionalCustomersId;

    /** 公司名称*/
    @ApiModelProperty(value = "公司名称", position = 5)
    private String name;

    /** 统一信用代码*/
    @ApiModelProperty(value = "统一信用代码", position = 7)
    private String uniformCreditCode;

    /** 资本类型*/
    @ApiModelProperty(value = "资本类型", position = 9)
    private String capitalType;

    /** 国别*/
    @ApiModelProperty(value = "国别", position = 10)
    private String country;

    /** 注册资金*/
    @ApiModelProperty(value = "注册资金", position = 11)
    private BigDecimal registeredFund;

    /** 币别*/
    @ApiModelProperty(value = "币别", position = 12)
    private String currency;

    /** 实收资金*/
    @ApiModelProperty(value = "实收资金", position = 13)
    private BigDecimal paidCapital;

    /** 注册地址--省*/
    @ApiModelProperty(value = "注册地址--省", position = 15)
    private String province;

    /** 注册地址--市*/
    @ApiModelProperty(value = "注册地址--市", position = 17)
    private String city;

    /** 注册地址--详细地址*/
    @ApiModelProperty(value = "注册地址--详细地址", position = 19)
    private String detailAddress;

    /** 成立日期*/
    @ApiModelProperty(value = "成立日期", position = 20)
    private LocalDate establishAt;

    /** 实际经营地址--省*/
    @ApiModelProperty(value = "实际经营地址--省", position = 15)
    private String businessProvince;

    /** 实际经营地址--市*/
    @ApiModelProperty(value = "实际经营地址--市", position = 17)
    private String businessCity;

    /** 实际经营地址--详细地址*/
    @ApiModelProperty(value = "实际经营地址--详细地址", position = 19)
    private String businessDetailAddress;

    /** 营业期限--开始*/
    @ApiModelProperty(value = "营业期限--开始", position = 21)
    private LocalDate operateStart;

    /** 营业期限--结束*/
    @ApiModelProperty(value = "营业期限--结束", position = 23)
    private LocalDate operateEnd;

    /** 行业分类*/
    @ApiModelProperty(value = "行业分类", position = 25)
    private String category;

    /** 主营业务*/
    @ApiModelProperty(value = "主营业务", position = 27)
    private String mainBusiness;
}