package com.cloudkeeper.leasing.base.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 基础vo
 * @author jerry
 */
@Getter
@Setter
public abstract class BaseVO {

    /** 主键*/
    @ApiModelProperty(value = "主键id", position = 1)
    private String id;

    /** 创建时间*/
    @ApiModelProperty(value = "创建时间", position = 2)
    private LocalDateTime createdAt;

    /** 更新时间*/
    @ApiModelProperty(value = "更新时间", position = 3)
    private LocalDateTime modifiedAt;

    /** 创建人*/
    @ApiModelProperty(value = "创建人", position = 4)
    private String createdBy;

    /** 更新人*/
    @ApiModelProperty(value = "更新人", position = 5)
    private String modifiedBy;

    /** 版本（乐观锁）*/
    @ApiModelProperty(value = "版本（乐观锁）", position = 6)
    private Integer version;

    /** 逻辑删除*/
    @ApiModelProperty(value = "逻辑删除", position = 7)
    private Integer isDelete;
}
