package com.cloudkeeper.leasing.company.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "司机vo", description = "司机Vo")
@Getter
@Setter
public class DriverVO extends BaseVO {

    /** 姓名*/
    @ApiModelProperty(value = "姓名", position = 1, required = true)
    private String name;

    /** 手机号*/
    @ApiModelProperty(value = "手机号", position = 3, required = true)
    private String mobileNumbers;

    /** 驾驶证号*/
    @ApiModelProperty(value = "驾驶证号", position = 5, required = true)
    private String licenseNumbers;
}
