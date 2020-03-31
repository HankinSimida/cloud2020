package cn.hankin.springcloud.alibaba.controller;

import cn.hankin.springcloud.entities.CommonResult;
import cn.hankin.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author hankin
 * @date 2020/3/31 23:44
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "123456789987654321"));
        hashMap.put(2L, new Payment(2L, "123456789aaaaaaaaa"));
        hashMap.put(3L, new Payment(3L, "12345678bbbbbbbbbb"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment p = hashMap.get(id);
        return new CommonResult<>(200, "form sql serverPort: " + serverPort, p);
    }
}
