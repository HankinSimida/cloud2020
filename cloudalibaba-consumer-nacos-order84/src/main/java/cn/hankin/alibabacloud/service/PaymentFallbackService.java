package cn.hankin.alibabacloud.service;

import cn.hankin.springcloud.entities.CommonResult;
import cn.hankin.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author hankin
 * @date 2020/4/1 0:44
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"bad service",new Payment(id,"error"));
    }
}
