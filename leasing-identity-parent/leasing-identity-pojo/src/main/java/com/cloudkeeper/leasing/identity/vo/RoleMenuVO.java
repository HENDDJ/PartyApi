package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色菜单vo
 * @author jerry
 */
@ApiModel(value = "角色菜单vo", description = "角色菜单vo")
@Getter
@Setter
public class RoleMenuVO extends BaseVO {

    /** 角色id*/
    @ApiModelProperty(value = "角色id", position = 10)
    private String roleId;

    /** 菜单id */
    @ApiModelProperty(value = "菜单id", position = 13, required = true)
    private String sysRouteId;

}
