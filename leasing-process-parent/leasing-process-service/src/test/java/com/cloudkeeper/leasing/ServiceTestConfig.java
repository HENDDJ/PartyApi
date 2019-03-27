package com.cloudkeeper.leasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ServiceTestConfig {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTestConfig.class, args);
    }
}
