package com.cloudkeeper.leasing;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * exclude = SecurityAutoConfiguration.class springboot2.0与activiti6.0.0集成使用，该类会报错，排除后可以正常使用
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaAuditing
@EnableEurekaClient
@EnableFeignClients
public class LeasingApplicationsProcess {

    public static void main(String[] args) {
        SpringApplication.run(LeasingApplicationsProcess.class, args);
    }

}
