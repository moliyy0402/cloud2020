package com.atguigu.order.client;

import com.atguigu.order.model.Payment;
import com.atguigu.order.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient("CLOUD-PAYMENT")
public interface PaymentService {
    @GetMapping("payment/{id}")
    Result<Payment> get(@PathVariable("id") Integer id);


    @GetMapping("payment/timeout")
    Integer timeout(@RequestParam("out")Long out);
}
