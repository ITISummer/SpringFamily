package com.itis.springcloud.service;

import com.itis.springcloud.entities.Payment;
import com.itis.springcloud.model.CRModel;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    CRModel create(Payment payment);
    CRModel getPaymentById(@Param("id") Long id);
}
