package com.itis.springcloud.service.impl;

import com.itis.springcloud.dao.PaymentDao;
import com.itis.springcloud.entities.Payment;
import com.itis.springcloud.model.CRModel;
import com.itis.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName PaymentServiceImpl
 * @Author LCX
 * @Date 2021 2021-06-12 9:22 p.m.
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Value("${server.port}")
    private String serverPort;

    @Override
    public CRModel create(Payment payment) {
        int res = paymentDao.create(payment);
        if (res > 0) {
            return new CRModel(200, "插入数据成功！serverPort: "+serverPort, res);
        }
        return new CRModel(400, "插入数据失败！serverPort: "+serverPort, null);
    }

    @Override
    public CRModel getPaymentById(Long id) {
        Payment payment = paymentDao.getPaymentById(id);
        if (payment != null) {
            System.out.println("lvlv:"+serverPort);
            return new CRModel(200, "获取数据成功！serverPort: "+serverPort, payment);
        }
        return new CRModel(400, "获取数据失败！serverPort: "+serverPort, null);
    }
}
