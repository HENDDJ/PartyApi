package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 登录日志 VO
 * @author lxw
 */
@ApiModel(value = "登录日志 VO", description = "登录日志 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysLoginLogVO extends BaseVO {

    /** 用户ID */
    @ApiModelProperty(value = "用户ID", position = 10, required = true)
    private String userId;

    /** 用户name */
    @ApiModelProperty(value = "用户name", position = 12, required = true)
    private String userName;

    /** 登陆时间 */
    @ApiModelProperty(value = "登陆时间", position = 14, required = true)
    private LocalDateTime loginTime;

    /** 登录成功 */
    @ApiModelProperty(value = "登录成功", position = 16, required = true)
    private String success;

}