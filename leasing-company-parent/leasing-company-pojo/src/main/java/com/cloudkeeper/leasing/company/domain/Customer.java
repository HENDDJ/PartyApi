package com.cloudkeeper.leasing.company.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 客户
 *
 * @author jerry
 */
@Getter
@Setter
@Entity
@Table(name = "l_cp_customer")
public class Customer extends BaseEntity {

    /** 公司父表id*/
    @ApiModelProperty(value = "公司父表id", position = 1, required = true)
    @Column(length = 36)
    private String parentId;

    /** 公司父表对象*/
    @ApiModelProperty(value = "公司父表对象", position = 2)
    @JoinColumn(name = "parentId", updatable = false, insertable = false)
    private CommonCompany commonCompany;

    /** 职工人数*/
    @ApiModelProperty(value = "职工人数", position = 3)
    private Integer staffNumber;

    /** 银行名称*/
    @ApiModelProperty(value = "银行名称", position = 5)
    @Column(length = 36)
    private String bankName;

    /** 银行账户*/
    @ApiModelProperty(value = "银行账户", position = 7)
    @Column(length = 36)
    private String bankAccount;

    /** 公司电话*/
    @ApiModelProperty(value = "公司电话", position = 9)
    @Column(length = 36)
    private String phoneNumber;

    /** 工厂地址--省*/
    @ApiModelProperty(value = "工厂地址--省", position = 11)
    @Column(length = 36)
    private String factoryProvince;

    /** 工厂地址--市*/
    @ApiModelProperty(value = "工厂地址--市", position = 13)
    @Column(length = 36)
    private String factoryCity;

    /** 工厂地址--详细地址*/
    @ApiModelProperty(value = "工厂地址--详细地址", position = 15)
    @Column(length = 200)
    private String factoryDetailAddress;
}
