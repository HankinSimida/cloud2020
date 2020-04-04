package cn.hankin.springcloud.alibaba.controller;

import cn.hankin.springcloud.alibaba.domain.CommonResult;
import cn.hankin.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author hankin
 * @date 2020/4/4 16:02
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @GetMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money")BigDecimal money){
        accountService.decrease(userId,money);
        try{
            TimeUnit.SECONDS.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return new CommonResult(200,"扣减账户余额成功");
    }
}
