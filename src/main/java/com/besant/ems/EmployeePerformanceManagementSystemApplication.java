package com.besant.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePerformanceManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            EmployeePerformanceManagementSystemApplication.class,
            args);
            System.out.println("Employee Performance Management System is running...");
    }
}