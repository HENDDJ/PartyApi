package com.cloudkeeper.leasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LeasingEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeasingEurekaServerApplication.class, args);
    }
}
