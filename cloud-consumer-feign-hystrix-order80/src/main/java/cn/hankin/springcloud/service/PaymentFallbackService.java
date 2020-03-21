package cn.hankin.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author hankin
 * @date 2020/3/22 0:17
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Long id) {
        return "PaymentFallbackService fall back - paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "PaymentFallbackService fall back paymentInfo_TimeOut";
    }
}
