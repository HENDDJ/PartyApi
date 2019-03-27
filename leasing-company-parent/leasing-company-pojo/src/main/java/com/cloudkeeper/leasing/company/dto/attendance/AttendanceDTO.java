package com.cloudkeeper.leasing.company.dto.attendance;

import com.cloudkeeper.leasing.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@ApiModel(value = "出勤dto", description = "出勤dto")
@Getter
@Setter
public class AttendanceDTO extends BaseDTO {

    /** 车辆信息表id*/
    @ApiModelProperty(value = "车辆信息表id", position = 1, required = true)
    @Length(max = 36)
    private String vehiclesId;

    /** 司机信息表id*/
    @ApiModelProperty(value = "司机信息表id", position = 5, required = true)
    @Length(max = 36)
    private String driversId;

    /** 具体关联的业务id*/
    @ApiModelProperty(value = "具体关联的业务id", position = 9)
    @Length(max = 36)
    private String itemId;

    /** 事由*/
    @ApiModelProperty(value = "事由", position = 11)
    @Length(max = 200)
    private String cause;

    /** 出勤开始时间*/
    @ApiModelProperty(value = "出勤开始时间", position = 13)
    private Date startTime;

    /** 出勤结束时间*/
    @ApiModelProperty(value = "出勤结束时间", position = 15)
    private Date endTime;

    /** 起始里程*/
    @ApiModelProperty(value = "起始里程", position = 17)
    @Length(max = 36)
    private String startMileage;

    /** 结束里程*/
    @ApiModelProperty(value = "结束里程", position = 19)
    @Length(max = 36)
    private String endMileage;
}
