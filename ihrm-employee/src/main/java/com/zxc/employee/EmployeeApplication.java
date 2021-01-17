package com.zxc.employee;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.zxc.employee","com.zxc"})
@EntityScan("com.zxc.model.employee")
public class EmployeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class);
    }
}
