package com.cloudkeeper.leasing.identity.dto.organization;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 组织查询DTO
 * @author jerry
 */
@Getter
@Setter
@ApiModel(value = "组织查询DTO", description = "组织查询DTO")
public class OrganizationSearchable extends BaseSearchable {

    /** 编码*/
    @ApiModelProperty(value = "编码", position = 10)
    private String code;

    /** 名称*/
    @ApiModelProperty(value = "名称", position = 12)
    private String name;
}
