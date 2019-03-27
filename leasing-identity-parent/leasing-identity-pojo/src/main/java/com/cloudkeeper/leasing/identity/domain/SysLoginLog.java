package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 登录日志
 * @author lxw
 */
@ApiModel(value = "登录日志", description = "登录日志")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_login_log")
public class SysLoginLog extends BaseEntity {

    /** userId */
    @ApiModelProperty(value = "用户ID", position = 10, required = true)
    @Column(length = 60)
    private String userId;

    /** userName */
    @ApiModelProperty(value = "用户name", position = 12, required = true)
    @Column(length = 60)
    private String userName;

    /** loginTime */
    @ApiModelProperty(value = "登陆时间", position = 14, required = true)
    @Column(length = 60)
    private LocalDateTime loginTime;

    /** success */
    @ApiModelProperty(value = "登录成功", position = 16, required = true)
    @Column(length = 60)
    private String success;




}
