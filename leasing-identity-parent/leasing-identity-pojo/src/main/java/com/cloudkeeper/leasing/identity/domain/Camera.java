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

/**
 * 监控
 * @author asher
 */
@ApiModel(value = "监控", description = "监控")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CM_Camera")
public class Camera extends BaseEntity {

    private String pid;
    private String cameraUuid;
    private String regionUuid;
    private String cameraName;
    private String nickName;
    private int cameraType;
    private String keyBoardCode;
    private String rtspURL;
    private int refreshCheck;
    private int enable;
}