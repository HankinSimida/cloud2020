package cn.hankin.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //服务降级
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String paymentInfo_TimeOut(Long id) {
//        int i = 10/0;
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread: " + Thread.currentThread().getName() + "paymentInfo_TimeOut: " + id + " gg " + time + "s";
    }

    public String paymentInfo_TimeOutHandler(Long id) {
        return "thread: " + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler: " + id + "---sorry---";
    }

    //-----服务熔断
    @HystrixCommand(fallbackMethod ="paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value ="true" ), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value ="10" ), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value ="10000" ), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value ="60" ), //失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        if (id < 0) {
            throw new RuntimeException("id < 0 : error");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "use successfully number:  " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Long id) {
        return "id < 0 error" + id;
    }


}
