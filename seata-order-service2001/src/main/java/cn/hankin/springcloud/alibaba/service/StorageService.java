package cn.hankin.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hankin
 * @date 2020/4/3 23:41
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @GetMapping(value = "/storage/decrease")
    void decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count);
}
