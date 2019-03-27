package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * 系统java类
 * @author asher
 */
@ApiModel(value = "系统java类", description = "系统java类")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_class")
public class SysClass extends BaseEntity {

    /** 类名 */
    @ApiModelProperty(value = "类名", position = 10, required = true)
    @Column(length = 36)
    private String name;

    /** 类描述 */
    @ApiModelProperty(value = "类描述", position = 10, required = true)
    @Column(length = 200)
    private String des;

    @ApiModelProperty(value = "属性集合")
    @OneToMany(mappedBy = "sysClass")
    @OrderBy("sort asc")
    private List<SysClassProperty> properties;

}