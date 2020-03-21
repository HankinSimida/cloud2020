package cn.hankin.springcloud.controller;

import cn.hankin.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author hankin
 * @date 2020/3/20 1:01
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paument_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Long id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    /*@GetMapping("/consumer/payment/hystrix/timeOut/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Long id){
        return paymentHystrixService.paymentInfo_TimeOut(id);

    }*/

    //服务降级
    @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id")Long id) {
//        int i = 10 / 0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id")Long id){
        return "---sorry---";
    }

    public String paument_Global_FallbackMethod(){
        return "global_fallback...";
    }
}
