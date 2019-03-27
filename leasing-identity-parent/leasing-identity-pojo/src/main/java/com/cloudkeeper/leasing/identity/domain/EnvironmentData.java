package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 环境数据类
 * @author asher
 */
@ApiModel(value = "环境数据类", description = "环境数据类")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ThirdParty_raiseDust")
public class EnvironmentData extends BaseEntity {

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