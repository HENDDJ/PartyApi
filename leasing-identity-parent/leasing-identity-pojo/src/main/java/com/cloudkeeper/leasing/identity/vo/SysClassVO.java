package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import com.cloudkeeper.leasing.identity.domain.SysClassProperty;
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
 * 系统java类 VO
 * @author asher
 */
@ApiModel(value = "系统java类 VO", description = "系统java类 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysClassVO extends BaseVO {

    /** 类名 */
    @ApiModelProperty(value = "类名", position = 10, required = true)
    private String name;

    /** 类描述 */
    @ApiModelProperty(value = "类描述", position = 10, required = true)
    private String des;

    @ApiModelProperty(value = "属性集合")
    private List<SysClassProperty> properties;

}