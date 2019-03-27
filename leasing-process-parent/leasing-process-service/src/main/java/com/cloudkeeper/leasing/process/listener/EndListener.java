package com.cloudkeeper.leasing.process.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 *
 */
public class EndListener implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("EndDelegateExecution is running!--" + execution);
    }
}
