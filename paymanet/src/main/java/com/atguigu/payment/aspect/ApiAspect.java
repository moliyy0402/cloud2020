package com.atguigu.payment.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.atguigu.payment.common.JacksonObjectMapper;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author moli
 */
@Slf4j
@Aspect
@Component
@Order(421)
public class ApiAspect {
    @Resource
    private JacksonObjectMapper objectMapper;

    @Pointcut("execution(public * com.atguigu.payment.controller..*.*(..))")
    public void pt() {
    }

    @Before("pt()")
    public void doAfter(JoinPoint joinPoint) throws JsonProcessingException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 方法
        Method method = methodSignature.getMethod();
        // 方法参数值
        Object[] args = joinPoint.getArgs();
        // 方法参数名
        Object[] parameters = methodSignature.getParameterNames();
        // 通过map封装参数和参数值
        HashMap<Object, Object> paramMap = new HashMap<>(5);
        for (int i = 0; i < parameters.length; i++) {
            paramMap.put(parameters[i], args[i]);
        }


        log.info("{}---->{}执行开始，参数：{}", "", method.getName(), objectMapper.writeValueAsString(paramMap));
    }

    @AfterThrowing(value = "pt()", throwing = "ex")
    public void doAfterThrowing(Throwable ex) {
        log.error("controller层发生异常：{}", ex.getMessage());
    }

    @AfterReturning(value = "pt()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 方法
        Method method = methodSignature.getMethod();

        log.info("{}---->{}执行结束，结果：{}", "", method.getName(), objectMapper.writeValueAsString(result));
    }

}
