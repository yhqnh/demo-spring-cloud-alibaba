package com.yhqnh.demo.spring.cloud.alibaba.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.yhqnh.demo.spring.cloud.alibaba"}, exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.yhqnh.demo.spring.cloud.alibaba")
public class ProductApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication2.class, args);
    }
}
