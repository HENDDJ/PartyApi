package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户组织vo
 * @author jerry
 */
@ApiModel(value = "用户组织vo", description = "用户组织vo")
@Getter
@Setter
public class PrincipalOrganizationVO extends BaseVO {

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
