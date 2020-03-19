package cn.hankin.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author hankin
 * @date 2020/3/20 0:20
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Long id) {
        return "thread: " + Thread.currentThread().getName() + "paymentInfo_OK: " + id + "哈哈";
    }

    public String paymentInfo_TimeOut(Long id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread: " + Thread.currentThread().getName() + "paymentInfo_TimeOut: " + id + " gg " + time + "s";
    }
}
