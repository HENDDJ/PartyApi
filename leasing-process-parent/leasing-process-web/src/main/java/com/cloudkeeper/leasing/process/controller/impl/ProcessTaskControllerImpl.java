package com.cloudkeeper.leasing.process.controller.impl;

import com.cloudkeeper.leasing.base.utils.BeanConverts;
import com.cloudkeeper.leasing.bean.process.to.TaskTO;
import com.cloudkeeper.leasing.process.controller.ProcessTaskController;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProcessTaskControllerImpl implements ProcessTaskController {

    /** 流程运行service*/
    @Autowired
    private RuntimeService runtimeService;

    /** 流程组织架构service*/
    @Autowired
    private IdentityService identityService;

    /** 流程任务service*/
    @Autowired
    private TaskService taskService;

    @Override
    public List<TaskTO> list(@PathVariable String id) {
        List<Task> list = taskService.createTaskQuery().processInstanceId(id).list();
        return BeanConverts.convert(list, TaskTO.class);
    }

    @Override
    public boolean complete(@PathVariable String processInstanceId) {
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
        String principalId = "";
        taskService.claim(task.getId(), principalId);
        Map<String, Object> variables = new HashMap<>();
        variables.put("reason", "同意");
        taskService.complete(task.getId(), variables);
        return true;
    }
}
