package com.cloudkeeper.leasing.company.dto.attendance;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "客户查询DTO", description = "客户查询DTO")
public class AttendanceSearchable extends BaseSearchable {

    /** 车辆信息表id*/
    @ApiModelProperty(value = "车辆信息表id", position = 1)
    private String vehiclesId;

    /** 司机信息表id*/
    @ApiModelProperty(value = "司机信息表id", position = 5)
    private String driversId;

    /** 具体关联的业务id*/
    @ApiModelProperty(value = "具体关联的业务id", position = 9)
    private String itemId;

    /** 事由*/
    @ApiModelProperty(value = "事由", position = 11)
    private String cause;

    /** 出勤开始时间*/
    @ApiModelProperty(value = "出勤开始时间", position = 13)
    private Date startTime;

    /** 出勤结束时间*/
    @ApiModelProperty(value = "出勤结束时间", position = 15)
    private Date endTime;

    /** 起始里程*/
    @ApiModelProperty(value = "起始里程", position = 17)
    private String startMileage;

    /** 结束里程*/
    @ApiModelProperty(value = "结束里程", position = 19)
    private String endMileage;
}
