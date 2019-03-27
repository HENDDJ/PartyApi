package com.cloudkeeper.leasing.bean.process.to;

import com.cloudkeeper.leasing.bean.base.to.BaseTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * 流程实例 TO
 * @author jerry
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProcessInstanceTO extends BaseTO {

    /** 流程定义id */
    private String processDefinitionId;

    /** 流程名称 */
    private String processDefinitionName;

    /** 流程key */
    private String processDefinitionKey;

    /** 版本 */
    private Integer processDefinitionVersion;

    /** 业务key */
    private String businessKey;

    /** 流程参数 */
    private Map<String, Object> processVariables;

    /** 名称 */
    private String name;

    /** key值 */
    private String key;

    /** 描述 */
    private String description;

    /** 部署id */
    private String deploymentId;

    /** 启动时间 */
    private LocalDateTime startTime;

    /** 发起人id */
    private String startUserId;
}
