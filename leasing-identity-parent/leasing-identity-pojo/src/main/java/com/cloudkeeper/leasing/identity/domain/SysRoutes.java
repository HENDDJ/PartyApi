package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "sys_routes")
public class SysRoutes extends BaseEntity implements Comparable{

    /** 父路由id */
    @ApiModelProperty(value = "父路由id", position = 1, required = true)
    @Column(length = 36)
    private String parentId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parentId", insertable = false, updatable = false)
    private SysRoutes sysRoutes;

    /** 类id */
    @ApiModelProperty(value = "类id", position = 3, required = true)
    @Column(length = 36)
    private String classId;

    @OneToOne
    @JoinColumn(name = "classId", insertable = false, updatable = false)
    private SysClass sysClass;

    /** 路由名称 */
    @ApiModelProperty(value = "路由名", position = 5, required = true)
    @Column(length = 36)
    private String name;

    /** 路由访问url地址 */
    @ApiModelProperty(value = "路由访问url地址", position = 7, required = true)
    @Column(length = 200)
    private String path;

    /** 组件名 */
    @ApiModelProperty(value = "组件名", position = 9, required = true)
    @Column(length = 50)
    private String componentName;

    /** 路由描述 */
    @ApiModelProperty(value = "路由描述", position = 11)
    @Column(length = 200)
    private String des;

    /** 路由meta */
    @ApiModelProperty(value = "路由meta", position = 13)
    @OneToOne(mappedBy = "sysRoutes")
    private SysRoutesMeta meta;

    /** 子路由*/
    @ApiModelProperty(value = "子路由", position = 13)
    @OneToMany(mappedBy = "sysRoutes")
    private List<SysRoutes> children;

    @Override
    public int compareTo(Object roleMenu) {
        LocalDateTime left=((SysRoutes)roleMenu).getCreatedAt();
        /* 正序排列 */
        return this.getCreatedAt().compareTo(left);
    }
}
