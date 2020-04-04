package cn.hankin.springcloud.alibaba.service.impl;

import cn.hankin.springcloud.alibaba.dao.AccountDao;
import cn.hankin.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author hankin
 * @date 2020/4/4 16:00
 */
@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("===========>account-service扣除账户开始");
        accountDao.decrease(userId,money);
        LOGGER.info("===========>account-service扣除账户结束");

    }
}
