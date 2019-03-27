package com.cloudkeeper.leasing.identity.dto.principalorganization;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户组织查询DTO
 * @author jerry
 */
@Getter
@Setter
@ApiModel(value = "用户组织查询DTO", description = "用户组织查询DTO")
public class PrincipalOrganizationSearchable extends BaseSearchable {

    /** 用户id*/
    @ApiModelProperty(value = "用户id", position = 10)
    private String principalId;

    /** 组织id*/
    @ApiModelProperty(value = "组织id", position = 13)
    private String organizationId;

    /** 是否兼职组织（岗位）*/
    @ApiModelProperty(value = "是否兼职组织", position = 16)
    private Integer isPart;
}
