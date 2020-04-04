package cn.hankin.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author hankin
 * @date 2020/4/4 15:56
 */
public interface AccountService {
    void decrease(@RequestParam("userId")Long userId, @RequestParam("money") BigDecimal money);
}
