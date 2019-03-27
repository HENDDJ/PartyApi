package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import com.cloudkeeper.leasing.identity.domain.SysClass;
import com.cloudkeeper.leasing.identity.domain.SysRoutes;
import com.cloudkeeper.leasing.identity.domain.SysRoutesMeta;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import java.util.List;

/**
 * 类属性配置 VO
 * @author asher
 */
@ApiModel(value = "类属性配置 VO", description = "类属性配置 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysRoutesVO extends BaseVO {

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

    /** 路由meta*/
    @ApiModelProperty(value = "路由meta", position = 13)
    private SysRoutesMeta meta;

    /** 子路由*/
    @ApiModelProperty(value = "子路由", position = 15)
    private List<SysRoutes> children;

    /** 对应类*/
    @ApiModelProperty(value = "对应类", position = 17)
    private SysClass sysClass;

}