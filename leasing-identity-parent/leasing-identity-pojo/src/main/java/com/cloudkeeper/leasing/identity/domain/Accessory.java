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
 * 系统附件
 *
 * @author asher
 */
@ApiModel(value = "系统附件", description = "系统附件")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ck_id_accessory")
public class Accessory extends BaseEntity {

    /** 名称*/
    @ApiModelProperty(value = "名称", position = 1, required = true)
    @Column(length = 36)
    private String name;

    /** 附件所对应主表id*/
    @ApiModelProperty(value = "附件所对应主表id", position = 2, required = true)
    @Column(length = 36)
    private String masterTableId;

    /** 主表对象*/
    @ApiModelProperty(value = "主表对象", position = 3, required = true)
    @Column(length = 36)
    private String masterObject;

    /** 类别*/
    @ApiModelProperty(value = "类别", position = 4)
    @Column(length = 36)
    private String type;

    /** 描述*/
    @ApiModelProperty(value = "描述", position = 5)
    @Column(length = 36)
    private String description;

    /** 存储路径*/
    @ApiModelProperty(value = "存储路径", position = 5)
    @Column(length = 36)
    private String path;
}