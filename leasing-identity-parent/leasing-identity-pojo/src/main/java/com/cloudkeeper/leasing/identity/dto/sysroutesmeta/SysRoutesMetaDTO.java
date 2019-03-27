package com.cloudkeeper.leasing.identity.dto.sysroutesmeta;

import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
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
 * 系统路由meta DTO
 * @author asher
 */
@ApiModel(value = "系统路由meta DTO", description = "系统路由meta DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysRoutesMetaDTO extends BaseEditDTO {

    /** 路由id */
    @ApiModelProperty(value = "路由id", position = 1, required = true)
    private String routeId;

    /** 标题 */
    @ApiModelProperty(value = "标题", position = 3)
    private String title;

    /** 图标 */
    @ApiModelProperty(value = "图标", position = 5)
    private String icon;

}