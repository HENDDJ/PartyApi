package com.cloudkeeper.leasing.company.dto.driver;

import com.cloudkeeper.leasing.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

@ApiModel(value = "司机dto", description = "司机dto")
@Getter
@Setter
public class DriverDTO extends BaseDTO {

    /** 姓名*/
    @ApiModelProperty(value = "姓名", position = 1, required = true)
    @Length(max = 36)
    private String name;

    /** 手机号*/
    @ApiModelProperty(value = "手机号", position = 3, required = true)
    @Length(max = 11)
    private String mobileNumbers;

    /** 驾驶证号*/
    @ApiModelProperty(value = "驾驶证号", position = 5, required = true)
    @Length(max = 50)
    private String licenseNumbers;
}
