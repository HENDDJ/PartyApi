package com.cloudkeeper.leasing.base.dto;

import com.cloudkeeper.leasing.base.enumeration.BooleanEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询条件dto
 * @author jerry
 */
@Getter
@Setter
public abstract class BaseSearchable extends BaseDTO {

    /** 逻辑删除*/
    @ApiModelProperty(value = "逻辑删除", position = 7)
    private Integer isDelete = BooleanEnum.FALSE.ordinal();
}
