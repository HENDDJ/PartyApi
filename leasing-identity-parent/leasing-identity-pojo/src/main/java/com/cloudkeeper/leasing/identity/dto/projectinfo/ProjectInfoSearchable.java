package com.cloudkeeper.leasing.identity.dto.projectinfo;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
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

/**
 * 工程信息类 查询DTO
 * @author asher
 */
@ApiModel(value = "工程信息类 查询DTO", description = "工程信息类 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoSearchable extends BaseSearchable {

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

}