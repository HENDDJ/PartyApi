package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 类属性配置
 * @author asher
 */
@ApiModel(value = "类属性配置", description = "类属性配置")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_routes_meta")
public class SysRoutesMeta extends BaseEntity {

    /** 路由id */
    @ApiModelProperty(value = "路由id", position = 1, required = true)
    @Column(length = 36)
    private String routeId;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "routeId", insertable = false, updatable = false)
    private SysRoutes sysRoutes;

    /** 标题 */
    @ApiModelProperty(value = "标题", position = 3)
    @Column(length = 36)
    private String title;

    /** 图标 */
    @ApiModelProperty(value = "图标", position = 5)
    @Column(length = 36)
    private String icon;

}