package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 系统属性
 * @author zhuwu
 * @version V1.0
 * @since 2018/9/30
 */
@ApiModel(value = "系统属性", description = "系统属性")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ck_id_property_config")
public class PropertyConfiguration extends BaseEntity {

    /** 属性名称 */
    @ApiModelProperty(value = "属性名称", position = 10, required = true)
    @Column(length = 50)
    private String name;

    /** 属性值 */
    @ApiModelProperty(value = "属性值", position = 12, required = true)
    @Column(length = 50)
    private String value;

    /** 属性说明 */
    @ApiModelProperty(value = "属性说明", position = 14, required = true)
    @Column(length = 100)
    private String description;
}
