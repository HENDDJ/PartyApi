package com.cloudkeeper.leasing.identity.dto.organizationrole;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 组织角色查询DTO
 * @author jerry
 */
@Getter
@Setter
@ApiModel(value = "组织角色查询DTO", description = "组织角色查询DTO")
public class OrganizationRoleSearchable extends BaseSearchable {

    /** 组织id*/
    @ApiModelProperty(value = "组织id", position = 10)
    private String organizationId;

    /** 角色id*/
    @ApiModelProperty(value = "角色id", position = 13)
    private String roleId;

}
