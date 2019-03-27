package com.cloudkeeper.leasing.company.dto.visitPlan;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "拜访计划Searchable", description = "拜访计划Searchable")
public class VisitPlanSearchable extends BaseSearchable {

    /** 开始时间*/
    @ApiModelProperty(value = "开始时间", position = 1)
    private Date startTime;

    /** 结束时间*/
    @ApiModelProperty(value = "结束时间", position = 3)
    @Length(max = 50)
    private Date endTime;

    /** 客户目的*/
    @ApiModelProperty(value = "客户目的", position = 5)
    @Length(max = 100)
    private String purpose;

    /** 客户来源*/
    @ApiModelProperty(value = "客户来源", position = 5)
    @Length(max = 100)
    private String source;

    /** 拜访区域（省份）*/
    @ApiModelProperty(value = "拜访区域（省份）", position = 7)
    @Length(max = 100)
    private String province;

    /** 拜访区域（城市）*/
    @ApiModelProperty(value = "拜访区域（城市）", position = 9)
    @Length(max = 100)
    private String city;

    /** 业务id*/
    @ApiModelProperty(value = "业务id", position = 11)
    @Length(max = 36)
    private String itemId;

    /** 是否委托同仁*/
    @ApiModelProperty(value = "是否委托同仁", position = 13)
    private Integer isEntrust;

    /** 是否主管陪同*/
    @ApiModelProperty(value = "是否主管陪同", position = 15)
    private Integer isAccompany;

    /** 被委托人Id*/
    @ApiModelProperty(value = "被委托人Id", position = 17)
    @Length(max = 36)
    private String mandataryId;

    /** 备注*/
    @ApiModelProperty(value = "备注", position = 21)
    @Length(max = 1000)
    private String note;
}
