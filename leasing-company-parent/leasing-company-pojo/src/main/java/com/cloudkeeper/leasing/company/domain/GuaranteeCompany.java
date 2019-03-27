package com.cloudkeeper.leasing.company.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * 担保公司
 * @author asher
 */
@ApiModel(value = "担保公司", description = "担保公司")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cp_guarantee_company")
public class GuaranteeCompany extends BaseEntity {

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

}