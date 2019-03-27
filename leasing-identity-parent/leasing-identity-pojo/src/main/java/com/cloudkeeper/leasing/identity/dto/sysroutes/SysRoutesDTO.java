package com.cloudkeeper.leasing.identity.dto.sysroutes;

import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
import com.cloudkeeper.leasing.identity.dto.sysroutesmeta.SysRoutesMetaDTO;
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
 * 系统路由 DTO
 * @author asher
 */
@ApiModel(value = "系统路由 DTO", description = "系统路由 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysRoutesDTO extends BaseEditDTO {

    /** 父路由id */
    @ApiModelProperty(value = "父路由id", position = 1, required = true)
    private String parentId;

    /** 类id */
    @ApiModelProperty(value = "类id", position = 3, required = true)
    private String classId;

    /** 路由名 */
    @ApiModelProperty(value = "路由名", position = 5, required = true)
    private String name;

    /** 路由访问url地址 */
    @ApiModelProperty(value = "路由访问url地址", position = 7, required = true)
    private String path;

    /** 组件名 */
    @ApiModelProperty(value = "组件名", position = 9, required = true)
    private String componentName;

    /** 路由描述 */
    @ApiModelProperty(value = "路由描述", position = 11)
    private String des;

    /** 路由元对象 */
    @ApiModelProperty(value = "路由元对象", position = 11)
    private SysRoutesMetaDTO meta;

}