package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 角色vo
 * @author jerry
 */
@ApiModel(value = "角色vo", description = "角色vo")
@Getter
@Setter
public class RoleVO extends BaseVO {

    /** 编码*/
    @ApiModelProperty(value = "编码", position = 10)
    private String code;

    /** 名称*/
    @ApiModelProperty(value = "名称", position = 12)
    private String name;

    /** 描述*/
    @ApiModelProperty(value = "描述", position = 14)
    private String note;

    /** 角色菜单*/
    @ApiModelProperty(value = "角色菜单", position = 20)
    private List<RoleMenuVO> roleMenuVOList;

    /** 组织 id*/
    @ApiModelProperty(value = "组织id", position = 22)
    private String organizationId;

    /** 组织 id*/
    @ApiModelProperty(value = "组织name", position = 22)
    private String organizationName;
}
