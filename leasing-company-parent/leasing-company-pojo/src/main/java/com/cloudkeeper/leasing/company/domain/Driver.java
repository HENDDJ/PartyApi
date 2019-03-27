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
 * 司机类
 */

@ApiModel(value = "司机类", description = "司机类")
@Getter
@Setter
@Entity
@Table(name = "cp_drivers")
public class Driver extends BaseEntity {

    /** 姓名*/
    @ApiModelProperty(value = "姓名", position = 1, required = true)
    @Column(length = 36)
    private String name;

    /** 手机号*/
    @ApiModelProperty(value = "手机号", position = 3, required = true)
    @Column(length = 11)
    private String mobileNumbers;

    /** 驾驶证号*/
    @ApiModelProperty(value = "驾驶证号", position = 5, required = true)
    @Column(length = 50)
    private String licenseNumbers;

}
