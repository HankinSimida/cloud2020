package cn.hankin.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author hankin
 * @date 2020/3/17 0:40
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String severPort;

    @GetMapping(value = "/payment/zk")
    public String paymentzk() {
        return "zookeeper: " + severPort + "\t" + UUID.randomUUID().toString();
    }
}
