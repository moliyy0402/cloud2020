package com.atguigu.payment.controller;


import com.atguigu.payment.model.Payment;
import com.atguigu.payment.model.Result;
import com.atguigu.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("zk")
    public Result<String> zk() {
        List<String> services = discoveryClient.getServices();
        services.forEach(log::info);

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment");
        instances.forEach(serviceInstance ->  {
            log.info("{}\t{}\t{}\t{}",serviceInstance.getInstanceId(),serviceInstance.getPort(),serviceInstance.getUri(),serviceInstance.getMetadata());
        });

        return Result.success();
    }
}
