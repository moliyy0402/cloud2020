package com.atguigu.order.controller;

import com.atguigu.order.client.PaymentService;
import com.atguigu.order.model.Payment;
import com.atguigu.order.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("payment")
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT/";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private PaymentService paymentService;


    @PostMapping("consumer/payment/add")
    public Result<Payment> add(@RequestBody Payment payment) {
        Result result = restTemplate.postForObject(PAYMENT_URL + "payment", payment, Result.class);
        return result;
    }

    @GetMapping("consumer/payment/{id}")
    public Result<Payment> get(@PathVariable Integer id) {
        Result<Payment> result = paymentService.get(id);
        return result;
    }

    @GetMapping("timeout")
    public Result<Integer> get() {
        Integer timeout = paymentService.timeout(0L);
        return Result.success(timeout);
    }

}
