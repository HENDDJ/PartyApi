package com.cloudkeeper.leasing.process.listener;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActivitiListener implements TaskListener, ExecutionListener {

    @Autowired
    private RuntimeService runtimeService;


    @Override
    public void notify(DelegateExecution execution) {
        System.out.println("xml流程：" + execution.getId() + " ActivitiListenner" + this.toString());
        System.out.println("activitiService: " + runtimeService.toString());
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("xml任务：" + delegateTask.getId() + " ActivitiListenner" + this.toString());
    }
}
