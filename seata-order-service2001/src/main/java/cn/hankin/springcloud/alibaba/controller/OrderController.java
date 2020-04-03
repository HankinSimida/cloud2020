package cn.hankin.springcloud.alibaba.controller;

import cn.hankin.springcloud.alibaba.domain.CommonResult;
import cn.hankin.springcloud.alibaba.domain.Order;
import cn.hankin.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hankin
 * @date 2020/4/3 23:53
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"success");
    }

}
