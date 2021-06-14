package com.itis.springcloud.controller;

import com.itis.springcloud.entities.Payment;
import com.itis.springcloud.model.CRModel;
import com.itis.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName PaymentController
 * @Author LCX
 * @Date 2021 2021-06-12 9:25 p.m.
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource // 同 @AutoWired
    private PaymentService paymentService;

    @PostMapping(value ="/payment/create")
    public CRModel create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CRModel getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

}
