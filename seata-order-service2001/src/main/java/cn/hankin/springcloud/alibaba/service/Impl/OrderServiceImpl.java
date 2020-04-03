package cn.hankin.springcloud.alibaba.service.Impl;

import cn.hankin.springcloud.alibaba.dao.OrderDao;
import cn.hankin.springcloud.alibaba.domain.Order;
import cn.hankin.springcloud.alibaba.service.AccountService;
import cn.hankin.springcloud.alibaba.service.OrderService;
import cn.hankin.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hankin
 * @date 2020/4/3 23:40
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {
        log.info("---新建订单");
        orderDao.create(order);

        log.info("---订单微服务开始调用库存，做扣减count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("---订单微服务开始调用库存，做扣减结束");

        log.info("---订单微服务开始调用账户，做扣减money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---订单微服务开始调用账户，做扣减end");

        //修改订单状态
        log.info("---修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("---修改订单状态结束");

        log.info("---下单结束 O(∩_∩)O哈哈~");
    }
}
