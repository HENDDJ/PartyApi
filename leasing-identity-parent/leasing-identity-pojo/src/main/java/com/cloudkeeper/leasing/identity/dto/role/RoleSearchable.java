package com.cloudkeeper.leasing.identity.dto.role;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色查询DTO
 * @author jerry
 */
@Getter
@Setter
@ApiModel(value = "角色查询DTO", description = "角色查询DTO")
public class RoleSearchable extends BaseSearchable {

    /** 编码*/
    @ApiModelProperty(value = "编码", position = 10)
    private String code;

    /** 名称*/
    @ApiModelProperty(value = "名称", position = 12)
    private String name;
}
