package com.cloudkeeper.leasing.identity.dto.sysclassproperty;

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
 * 类属性配置 查询DTO
 * @author asher
 */
@ApiModel(value = "类属性配置 查询DTO", description = "类属性配置 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysClassPropertySearchable extends BaseSearchable {

    /** 类id */
    @ApiModelProperty(value = "类id", position = 1, required = true)
    private String classId;

    /** 属性名 */
    @ApiModelProperty(value = "属性名", position = 3, required = true)
    private String name;

    /** 数据类型 */
    @ApiModelProperty(value = "数据类型", position = 5)
    private String type;

    /** 长度 */
    @ApiModelProperty(value = "长度", position = 7)
    private Integer length;

    /** 属性描述 */
    @ApiModelProperty(value = "属性描述", position = 9)
    private String des;

    /** 排序 */
    @ApiModelProperty(value = "排序", position = 11)
    private Integer sort;

    /** 父id */
    @ApiModelProperty(value = "父id", position = 13)
    private String parentId;

    /** 是否必填*/
    @ApiModelProperty(value = "是否必填", position = 19)
    private String required;

    /** 离开触发*/
    @ApiModelProperty(value = "触发类型", position = 21)
    private String triggerCheck;

    /** 最小长度*/
    @ApiModelProperty(value = "最小长度", position = 23)
    private String min;

    /** 最大长度*/
    @ApiModelProperty(value = "最大长度", position = 25)
    private String max;

    /** 类型验证*/
    @ApiModelProperty(value = "类型验证", position = 27)
    private String typeCheck;

    @ApiModelProperty(value = "表格是否不显示", position = 29)
    private String notShow;

    @ApiModelProperty(value = "转换类型", position = 22, required = true)
    private String transferType;

    @ApiModelProperty(value = "转换KEY", position = 23, required = true)
    private String lookupKey;

    @ApiModelProperty(value = "表单是否不显示", position = 29)
    private String formShow;

    @ApiModelProperty(value = "别名", position = 30)
    private String aliasName;
}
