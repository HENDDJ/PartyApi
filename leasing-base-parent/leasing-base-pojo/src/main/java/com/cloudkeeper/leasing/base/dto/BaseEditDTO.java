package com.cloudkeeper.leasing.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 基础dto
 * @author jerry
 */
@Getter
@Setter
public abstract class BaseEditDTO extends BaseDTO {

    /** 版本（乐观锁）*/
    @ApiModelProperty(value = "版本（乐观锁）", position = 6)
    private Integer version = 0;

    /** id*/
    @ApiModelProperty(value = "id", position = 7)
    private String id;
}
