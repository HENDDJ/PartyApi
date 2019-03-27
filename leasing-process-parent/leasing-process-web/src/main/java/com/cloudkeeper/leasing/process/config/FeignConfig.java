package com.cloudkeeper.leasing.process.config;

import com.cloudkeeper.leasing.base.constant.AuthorizationConstants;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * feign 添加请求头 token
 * @author jerry
 */
@Configuration
public class FeignConfig {

    @Bean
    public HystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
        return new RequestAttributeHystrixConcurrencyStrategy();
    }

    @Bean
    public RequestInterceptor headerInterceptor() {
        return requestTemplate -> {
            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
            String token = request.getHeader(AuthorizationConstants.AUTHORIZATION);
            requestTemplate.header("authorization", token);
        };
    }

}
