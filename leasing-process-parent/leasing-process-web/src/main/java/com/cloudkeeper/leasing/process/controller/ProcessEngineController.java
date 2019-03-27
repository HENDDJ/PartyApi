package com.cloudkeeper.leasing.process.controller;

import com.cloudkeeper.leasing.bean.process.to.ProcessDefinitionTO;
import com.cloudkeeper.leasing.bean.process.to.ProcessInstanceTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/processEngine")
public interface ProcessEngineController {

    /**
     * 流程定义列表
     * @return 流程定义集合
     */
    @GetMapping("/list")
    List<ProcessDefinitionTO> list();

    /**
     * 启动一个流程实例
     * @param key 流程定义key
     * @return 流程实例id
     */
    @PostMapping("/start")
    String start(String key);

    /**
     * 流程实例列表
     * @return 流程实例集合
     */
    @GetMapping("/list/{definitionKey}definitionKey")
    List<ProcessInstanceTO> list(@PathVariable String definitionKey);

    /**
     * 获取流程实例
     * @param id 流程实例id
     * @return 流程实例
     */
    @GetMapping("/processInstance/{id}id")
    ProcessInstanceTO getById(@PathVariable String id);


    // 查询流程实例当前节点
    // 查询流程实例当前审核人
    // 查询流程实例历史节点
}
