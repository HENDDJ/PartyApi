package com.cloudkeeper.leasing.company.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 拜访计划类
 */

@ApiModel(value = "拜访计划类", description = "拜访计划类")
@Getter
@Setter
@Entity
@Table(name = "cp_visit_plan")
public class VisitPlan extends BaseEntity{

    /** 开始时间*/
    @ApiModelProperty(value = "开始时间", position = 1)
    private LocalDate startTime;

    /** 结束时间*/
    @ApiModelProperty(value = "结束时间", position = 3)
    @Column(length = 50)
    private LocalDate endTime;

    /** 客户目的*/
    @ApiModelProperty(value = "客户目的", position = 5)
    @Column(length = 100)
    private String purpose;

    /** 客户来源*/
    @ApiModelProperty(value = "客户来源", position = 5)
    @Column(length = 100)
    private String source;

    /** 拜访区域（省份）*/
    @ApiModelProperty(value = "拜访区域（省份）", position = 7)
    @Column(length = 100)
    private String province;

    /** 拜访区域（城市）*/
    @ApiModelProperty(value = "拜访区域（城市）", position = 9)
    @Column(length = 100)
    private String city;

    /** 业务id*/
    @ApiModelProperty(value = "业务id", position = 11)
    @Column(length = 36)
    private String itemId;

    /** 是否委托同仁*/
    @ApiModelProperty(value = "是否委托同仁", position = 13)
    private Integer isEntrust;

    /** 是否主管陪同*/
    @ApiModelProperty(value = "是否主管陪同", position = 15)
    private Integer isAccompany;

    /** 被委托人Id*/
    @ApiModelProperty(value = "被委托人Id", position = 17)
    @Column(length = 36)
    private String mandataryId;

    /** 备注*/
    @ApiModelProperty(value = "备注", position = 21)
    @Column(length = 1000)
    private String note;

}
