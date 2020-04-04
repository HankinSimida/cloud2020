package cn.hankin.springcloud.alibaba.controller;

import cn.hankin.springcloud.alibaba.domain.CommonResult;
import cn.hankin.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hankin
 * @date 2020/4/4 15:39
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @GetMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }
}
