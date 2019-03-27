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
 * 供应商
 * @author asher
 */
@ApiModel(value = "供应商", description = "供应商")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cp_supplier")
public class Supplier extends BaseEntity {

    /** 公司父表id*/
    @ApiModelProperty(value = "公司父表id", position = 1, required = true)
    @Column(length = 36)
    private String parentId;

    /** 公司父表对象*/
    @ApiModelProperty(value = "公司父表对象", position = 2)
    @JoinColumn(name = "parentId", updatable = false, insertable = false)
    private CommonCompany commonCompany;

    /** 供应商类别 */
    @ApiModelProperty(value = "供应商类别", position = 1, required = true)
    @Column(length = 60)
    private String category;

}