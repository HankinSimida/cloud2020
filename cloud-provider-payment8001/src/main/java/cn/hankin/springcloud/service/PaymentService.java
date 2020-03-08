package cn.hankin.springcloud.service;

import cn.hankin.springcloud.entities.Payment;

/**
 * @author hankin
 * @date 2020/3/8 22:30
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
