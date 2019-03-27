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
import java.util.Date;

/**
 * 工程信息类
 * @author asher
 */
@ApiModel(value = "工程信息类", description = "工程信息类")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRO_Project")
public class ProjectInfo extends BaseEntity {
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
    private Date startTime;
    private Date endTime;
    private Integer enable;

}