package com.cloudkeeper.leasing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springMVC 配置
 * @author jerry
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /** 登录token拦截器*/
    @Autowired
    private AccessTokenInterceptor accessTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessTokenInterceptor);
    }
}
