package com.cloudkeeper.leasing.company.manager.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.bean.identity.to.PrincipalTO;
import com.cloudkeeper.leasing.company.manager.PrincipalManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 降级处理
 * @author jerry
 */
@Slf4j
@Service
public class PrincipalManagerFallback implements PrincipalManager {

    @Override
    public Result<PrincipalTO> findOne(String id) {
        return Result.of(Result.ResultCode.FAIL.getCode(), "principal findOne 请求失败！");
    }

}
