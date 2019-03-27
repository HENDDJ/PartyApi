package com.cloudkeeper.leasing.company.manager;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.bean.identity.to.PrincipalTO;
import com.cloudkeeper.leasing.company.manager.impl.PrincipalManagerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "API-IDENTITY", fallback = PrincipalManagerFallback.class)
public interface PrincipalManager {

    @GetMapping(value = "/principal/to/{id}id")
    Result<PrincipalTO> findOne(@PathVariable("id") String id);

}
