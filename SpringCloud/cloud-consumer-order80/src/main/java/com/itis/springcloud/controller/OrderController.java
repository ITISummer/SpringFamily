package com.itis.springcloud.controller;

import com.itis.springcloud.entities.Payment;
import com.itis.springcloud.model.CRModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Author LCX
 * @Date 2021 2021-06-13 11:46 a.m.
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderController {
    // 单机版写死了服务地址
//   public static final String PAYMENT_URL = "http://localhost:8001";
   // 集群版直接写服务名称
   public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
   @Resource
   private RestTemplate restTemplate;

   @GetMapping(value = "/consumer/payment/create")
   public CRModel<Payment> create(Payment payment) {
      return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CRModel.class);
   }

   @GetMapping(value = "/consumer/payment/get/{id}")
   public CRModel<Payment> getPayment(@PathVariable("id") Long id) {
      return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CRModel.class);
   }
}
