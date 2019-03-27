package com.cloudkeeper.leasing.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * zuul Fallback config
 * 为所有路由的server-id 提供统一的 Fallback
 * @author jerry
 */
@Setter
@Component
@ConfigurationProperties("zuul")
public class ProviderConfig {

    /** 来源于 配置文件的 zuul.routes 属性*/
    private Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Runnable dynamicConfiguration() {
        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        // 为所有路由的server-id 创建 Fallback 并注册到容器中
        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routes.entrySet()) {
            String serviceId = entry.getValue().getServiceId();
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(ServiceFallbackProvider.class);
            beanDefinitionBuilder.addPropertyValue("route", serviceId);
            // 注册到spring容器中
            beanFactory.registerBeanDefinition(serviceId + "ServiceFallbackProvider", beanDefinitionBuilder.getBeanDefinition());
        }
        return null;
    }

    @Setter
    @Getter
    public class ServiceFallbackProvider implements FallbackProvider {

        private String route;

        @Override
        public String getRoute() {
            return route;
        }

        @Override
        public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
            return new ClientHttpResponse() {

                @Override
                @Nonnull
                public InputStream getBody() {
                    // 当出现服务调用错误之后返回的数据内容
                    String json = "{\"code\": 500, \"msg\": \"服务器错误\"}";
                    return new ByteArrayInputStream(json.getBytes());
                }

                @Override
                @Nonnull
                public HttpHeaders getHeaders() {
                    HttpHeaders headers = new HttpHeaders();
                    headers.set("Content-Type", "text/html; charset=UTF-8");
                    return headers;
                }

                @Override
                @Nonnull
                public HttpStatus getStatusCode() {
                    return HttpStatus.BAD_REQUEST;
                }

                @Override
                public int getRawStatusCode() {
                    return HttpStatus.BAD_REQUEST.value();
                }

                @Override
                @Nonnull
                public String getStatusText() {
                    return HttpStatus.BAD_REQUEST.getReasonPhrase();
                }

                @Override
                public void close() {

                }
            };
        }
    }
}
