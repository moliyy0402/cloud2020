package com.atguigu.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.atguigu.payment.mapper")
@EnableDiscoveryClient
public class PaymentApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PaymentApplication.class, args);

    }
}
