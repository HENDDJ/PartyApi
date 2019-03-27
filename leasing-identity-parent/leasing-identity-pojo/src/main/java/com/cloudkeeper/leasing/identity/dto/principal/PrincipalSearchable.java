package com.cloudkeeper.leasing.identity.dto.principal;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户查询DTO
 * @author jerry
 */
@Getter
@Setter
@ApiModel(value = "用户查询DTO", description = "用户查询DTO")
public class PrincipalSearchable extends BaseSearchable {

    /** 登录名*/
    @ApiModelProperty(value = "登录名", position = 10)
    private String code;

    /** 姓名*/
    @ApiModelProperty(value = "姓名", position = 12)
    private String name;

    /** 组织编码*/
    @ApiModelProperty(value = "组织编码", position = 10)
    private String organizationCode;
}
