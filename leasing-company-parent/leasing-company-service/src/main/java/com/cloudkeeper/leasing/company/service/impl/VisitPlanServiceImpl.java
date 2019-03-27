package com.cloudkeeper.leasing.company.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.company.domain.VisitPlan;
import com.cloudkeeper.leasing.company.repository.VisitPlanRepository;
import com.cloudkeeper.leasing.company.service.VisitPlanService;
import org.springframework.beans.factory.annotation.Autowired;

public class VisitPlanServiceImpl extends BaseServiceImpl<VisitPlan> implements VisitPlanService {

    /** 拜访计划 Repository*/
    @Autowired
    private VisitPlanRepository visitPlanRepository;

    @Override
    protected BaseRepository<VisitPlan> getBaseRepository() {
        return visitPlanRepository;
    }
}
