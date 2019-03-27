package com.cloudkeeper.leasing.identity.dto.accessory;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
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
 * 系统附件 查询DTO
 * @author asher
 */
@ApiModel(value = "系统附件 查询DTO", description = "系统附件 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AccessorySearchable extends BaseSearchable {

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 1)
    private String name;

    /** 附件所对应主表id */
    @ApiModelProperty(value = "附件所对应主表id", position = 2)
    private String masterTableId;

    /** 主表对象 */
    @ApiModelProperty(value = "主表对象", position = 3)
    private String masterObject;

    /** 类别 */
    @ApiModelProperty(value = "类别", position = 4)
    private String type;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 5)
    private String description;

    /** 存储路径 */
    @ApiModelProperty(value = "存储路径", position = 5)
    private String path;

}