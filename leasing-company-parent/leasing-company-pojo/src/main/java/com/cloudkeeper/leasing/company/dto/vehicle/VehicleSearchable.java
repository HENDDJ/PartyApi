package com.cloudkeeper.leasing.company.dto.vehicle;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ApiModel(value = "车辆查询Searchable", description = "车辆查询Searchable")
public class VehicleSearchable extends BaseSearchable {

    /** 车牌号码*/
    @ApiModelProperty(value = "车牌号码", position = 1)
    @Length(max = 36)
    private String licensePlate;

    /** 最大载客数*/
    @ApiModelProperty(value = "最大载客数", position = 3)
    @Length(max = 24)
    private String maximumPassenger;

    /** 型号*/
    @ApiModelProperty(value = "型号", position = 5)
    @Length(max = 100)
    private String model;

}
