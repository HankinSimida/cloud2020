package cn.hankin.springcloud.alibaba.myhandler;

import cn.hankin.springcloud.entities.CommonResult;
import cn.hankin.springcloud.entities.Payment;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author hankin
 * @date 2020/3/30 23:46
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(444, "global handlerException", new Payment(2020L, "serial00x"));
    }
    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(444, "global handlerException2", new Payment(2020L, "serial00x"));
    }
}
