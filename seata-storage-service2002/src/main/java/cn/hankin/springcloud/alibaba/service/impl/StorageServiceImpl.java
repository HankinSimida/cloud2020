package cn.hankin.springcloud.alibaba.service.impl;

import cn.hankin.springcloud.alibaba.dao.StorageDao;
import cn.hankin.springcloud.alibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hankin
 * @date 2020/4/4 15:34
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {

        LOGGER.info("===========>storage-service扣除库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("===========>storage-service扣除库存结束");
    }
}
