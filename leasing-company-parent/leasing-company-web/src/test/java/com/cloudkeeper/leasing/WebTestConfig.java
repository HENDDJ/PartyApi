package com.cloudkeeper.leasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebTestConfig {

    public static void main(String[] args) {
        SpringApplication.run(WebTestConfig.class, args);
    }

}
