package com.cloudkeeper.leasing.company.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 出勤信息类
 */

@ApiModel(value = "出勤信息类", description = "出勤信息类")
@Getter
@Setter
@Entity
@Table(name = "cp_attendances")
public class Attendance extends BaseEntity {

    /** 车辆信息表id*/
    @ApiModelProperty(value = "车辆信息表id", position = 1, required = true)
    @Column(length = 36)
    private String vehiclesId;

    /** 车辆*/
    @ApiModelProperty(value = "车辆", position = 3, required = true)
    @OneToOne
    @JoinColumn(name = "vehiclesId", updatable = false, insertable = false)
    private Vehicle vehicle;

    /** 司机信息表id*/
    @ApiModelProperty(value = "司机信息表id", position = 5, required = true)
    @Column(length = 36)
    private String driversId;

    /** 司机*/
    @ApiModelProperty(value = "司机", position = 7, required = true)
    @OneToOne
    @JoinColumn(name = "driversId", updatable = false, insertable = false)
    private Driver driver;

    /** 具体关联的业务id*/
    @ApiModelProperty(value = "具体关联的业务id", position = 9)
    @Column(length = 36)
    private String itemId;

    /** 事由*/
    @ApiModelProperty(value = "事由", position = 11)
    @Column(length = 200)
    private String cause;

    /** 出勤开始时间*/
    @ApiModelProperty(value = "出勤开始时间", position = 13)
    private LocalDate startTime;

    /** 出勤结束时间*/
    @ApiModelProperty(value = "出勤结束时间", position = 15)
    private LocalDate endTime;

    /** 起始里程*/
    @ApiModelProperty(value = "起始里程", position = 17)
    @Column(length = 36)
    private Double startMileage;

    /** 结束里程*/
    @ApiModelProperty(value = "结束里程", position = 19)
    @Column(length = 36)
    private Double endMileage;
}
