package com.cloudkeeper.leasing.company.dto.driver;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "司机Searchable", description = "司机Searchable")
public class DriverSearchable extends BaseSearchable {

    /** 姓名*/
    @ApiModelProperty(value = "姓名", position = 1)
    private String name;

    /** 手机号*/
    @ApiModelProperty(value = "手机号", position = 3)
    private String mobileNumbers;

    /** 驾驶证号*/
    @ApiModelProperty(value = "驾驶证号", position = 5)
    private String licenseNumbers;
}
