package com.cloudkeeper.leasing.identity.dto.environmentdata;

import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
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
 * 环境数据类 DTO
 * @author asher
 */
@ApiModel(value = "环境数据类 DTO", description = "环境数据类 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDataDTO extends BaseEditDTO {

    private String deviceName;

    private String projectNumber;

    private String deviceCode;

    private String Pm25;

    private String Pm10;

    private String windSpeed;

    private String windDirection;

    private String windPower;

    private String noise;

    private String temperture;

    private String humidty;

    private String atmos;

    private String TSP;

    private String createTime;

}