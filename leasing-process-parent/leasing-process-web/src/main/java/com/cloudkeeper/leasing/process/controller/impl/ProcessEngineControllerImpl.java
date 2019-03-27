package com.cloudkeeper.leasing.process.controller.impl;

import com.cloudkeeper.leasing.base.utils.BeanConverts;
import com.cloudkeeper.leasing.bean.process.to.ProcessDefinitionTO;
import com.cloudkeeper.leasing.bean.process.to.ProcessInstanceTO;
import com.cloudkeeper.leasing.process.controller.ProcessEngineController;
import lombok.RequiredArgsConstructor;
import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProcessEngineControllerImpl implements ProcessEngineController {

    /** 流程运行service*/
    private final RuntimeService runtimeService;

    /** 流程组织架构service*/
    private final IdentityService identityService;

    /** 流程任务service*/
    private final TaskService taskService;

    /** 流程历史service*/
    private final HistoryService historyService;

    /** 流程仓库service*/
    private final RepositoryService repositoryService;

    @Override
    public List<ProcessDefinitionTO> list() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        return BeanConverts.convert(list, ProcessDefinitionTO.class);
    }

    @Override
    public String start(String key) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
        return processInstance.getId();
    }

    @Override
    public List<ProcessInstanceTO> list(String definitionKey) {
        List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery().processDefinitionKey(definitionKey).list();
        return BeanConverts.convert(processInstanceList, ProcessInstanceTO.class);
    }

    @Override
    public ProcessInstanceTO getById(String id) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(id).singleResult();
        return BeanConverts.convert(processInstance, ProcessInstanceTO.class);
    }

//    @Override
//    public String start(String key, String name) {
//        String principalId = "";
//        identityService.setAuthenticatedUserId(principalId);
//        Map<String, Object> variables1 = new HashMap<>();
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(name, variables1);
//        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
//        task.setOwner(principalId);
//        taskService.claim(task.getId(), principalId);
//        Map<String, Object> variables = new HashMap<>();
//        variables.put("reason", "提交");
//        taskService.complete(task.getId(), variables);
//        return processInstance.getId();
//    }
}
