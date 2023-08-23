package com.atguigu.payment.service.impl;

import com.atguigu.payment.mapper.PaymentMapper;
import com.atguigu.payment.model.Payment;
import com.atguigu.payment.service.PaymentService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
}
