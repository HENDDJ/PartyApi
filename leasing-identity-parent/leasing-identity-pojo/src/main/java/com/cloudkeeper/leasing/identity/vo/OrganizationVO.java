package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.identity.enumeration.OrganizationTypeEnum;
import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

/**
 * 组织vo
 * @author jerry
 */
@ApiModel(value = "组织vo", description = "组织vo")
@Getter
@Setter
public class OrganizationVO extends BaseVO {

    /** 编码*/
    @ApiModelProperty(value = "编码", position = 10)
    private String code;

    /** 全编码*/
    @ApiModelProperty(value = "全编码", position = 11)
    private String fullCode;

    /** 名称*/
    @ApiModelProperty(value = "名称", position = 12)
    private String name;

    /** 父id*/
    @ApiModelProperty(value = "父id", position = 14)
    private String parentId;

    /** 组织类型*/
    @ApiModelProperty(value = "组织类型", position = 16)
    @Enumerated(value = EnumType.STRING)
    private OrganizationTypeEnum type;

    /** 排序*/
    @ApiModelProperty(value = "排序", position = 18)
    private Integer sort;

    /** 描述*/
    @ApiModelProperty(value = "描述", position = 20)
    private String note;

    /** 子节点*/
    @ApiModelProperty(value = "子节点", position = 22)
    private List<OrganizationVO> children = new ArrayList<>();

    /** 角色*/
    @ApiModelProperty(value = "角色", position = 24)
    private List<RoleVO> roleVOList;
}
