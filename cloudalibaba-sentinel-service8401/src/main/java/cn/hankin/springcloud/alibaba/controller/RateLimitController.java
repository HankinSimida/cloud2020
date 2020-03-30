package cn.hankin.springcloud.alibaba.controller;

import cn.hankin.springcloud.alibaba.myhandler.CustomerBlockHandler;
import cn.hankin.springcloud.entities.CommonResult;
import cn.hankin.springcloud.entities.Payment;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hankin
 * @date 2020/3/30 23:30
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){
        return new CommonResult(200,"ok",new Payment(2020L,"serial001"));
    }

    public CommonResult handlerException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+" can not use");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"url ok!",new Payment(2020L,"serial002"));
    }
    @GetMapping("/rateLimit/customerHandler")
    @SentinelResource(value = "customerHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult customerHandler(){
        return new CommonResult(200,"customerHandler ok!",new Payment(2020L,"serial003"));
    }
}
