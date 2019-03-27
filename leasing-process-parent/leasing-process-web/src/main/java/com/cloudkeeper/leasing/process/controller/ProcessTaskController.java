package com.cloudkeeper.leasing.process.controller;

import com.cloudkeeper.leasing.bean.process.to.TaskTO;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/processTask")
public interface ProcessTaskController {

    /**
     * 流程定义任务列表
     * @return 任务集合
     */
    @GetMapping("/list/processInstanceId{id}")
    List<TaskTO> list(@PathVariable String id);

    /**
     * 查询流程实例当前节点
     * @param processInstanceId 业务id
     * @return 流程实例
     */
    @PutMapping("/complete/processInstanceId{processInstanceId}")
    boolean complete(@PathVariable String processInstanceId);

    // 查询流程实例当前审核人
    // 查询流程实例历史节点
}
