package com.cloudkeeper.leasing.bean.process.to;

import com.cloudkeeper.leasing.bean.base.to.BaseTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 流程定义 TO
 * @author jerry
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProcessDefinitionTO extends BaseTO {

    /** 名称 */
    private String name;

    /** key值 */
    private String key;

    /** 描述 */
    private String description;

    /** 版本 */
    private int version;

    /** 部署id */
    private String deploymentId;
}
