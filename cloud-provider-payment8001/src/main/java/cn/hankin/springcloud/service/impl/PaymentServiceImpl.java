package cn.hankin.springcloud.service.impl;

import cn.hankin.springcloud.dao.PaymentDao;
import cn.hankin.springcloud.entities.Payment;
import cn.hankin.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hankin
 * @date 2020/3/8 22:32
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
