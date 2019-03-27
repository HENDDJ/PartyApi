package com.cloudkeeper.leasing.company.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel(value = "出勤vo", description = "出勤vo")
@Getter
@Setter
public class AttendanceVO extends BaseVO {

    /** 车辆信息表id*/
    @ApiModelProperty(value = "车辆信息表id", position = 1, required = true)
    private String vehiclesId;

    /** 司机信息表id*/
    @ApiModelProperty(value = "司机信息表id", position = 5, required = true)
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
