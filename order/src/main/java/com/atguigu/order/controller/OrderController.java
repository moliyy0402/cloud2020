package com.atguigu.order.controller;

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


    @PostMapping("consumer/payment/add")
    public Result<Payment> add(@RequestBody Payment payment) {
        Result result = restTemplate.postForObject(PAYMENT_URL + "payment", payment, Result.class);
        return result;
    }

    @GetMapping("consumer/payment/{id}")
    public Result<Payment> get(@PathVariable Integer id) {
        Result result = restTemplate.getForObject(PAYMENT_URL + "payment/"+id, Result.class);
        return result;
    }

}
