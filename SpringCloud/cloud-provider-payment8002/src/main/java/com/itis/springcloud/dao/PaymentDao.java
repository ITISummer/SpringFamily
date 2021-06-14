package com.itis.springcloud.dao;

import com.itis.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentDao
 * @Author LCX
 * @Date 2021 2021-06-12 8:57 p.m.
 * @Version 1.0
 **/
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
