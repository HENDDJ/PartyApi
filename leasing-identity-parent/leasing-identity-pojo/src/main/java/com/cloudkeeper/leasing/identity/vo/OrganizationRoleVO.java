package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 组织角色vo
 * @author jerry
 */
@ApiModel(value = "组织角色vo", description = "组织角色vo")
@Getter
@Setter
public class OrganizationRoleVO extends BaseVO {

    /** 组织id*/
    @ApiModelProperty(value = "组织id", position = 10)
    private String organizationId;

    /** 角色id*/
    @ApiModelProperty(value = "角色id", position = 13)
    private String roleId;

}
