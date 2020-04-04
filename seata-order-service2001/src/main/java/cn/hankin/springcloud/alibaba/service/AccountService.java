package cn.hankin.springcloud.alibaba.service;

import cn.hankin.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author hankin
 * @date 2020/4/3 23:41
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @GetMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money);
}
