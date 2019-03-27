package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 工程信息类 VO
 * @author asher
 */
@ApiModel(value = "工程信息类 VO", description = "工程信息类 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoVO extends BaseVO {

    private String name;

    private String number;

    private String longitude;

    private String latitude;

    private String department;

    private String responsibility;

    private String address;

    private String investment;

    private String licenseNumber;

    private String type;

    private String property;

    private String size;

    private String license;

    private String sourcesFunds;

    private Integer isHazard;

    private Integer isFormwork;

    private Integer isDeepExcavation;

    private Integer enable;

    private Date startTime;

    private Date endTime;

}