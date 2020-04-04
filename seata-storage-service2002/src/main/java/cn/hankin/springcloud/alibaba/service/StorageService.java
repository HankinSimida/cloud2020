package cn.hankin.springcloud.alibaba.service;

/**
 * @author hankin
 * @date 2020/4/4 15:33
 */
public interface StorageService {
    void decrease(Long productId,Integer count);
}
