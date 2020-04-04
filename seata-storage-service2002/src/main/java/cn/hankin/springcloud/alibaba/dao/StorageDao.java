package cn.hankin.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hankin
 * @date 2020/4/2 1:07
 */
@Mapper
public interface StorageDao {
    void decrease(@Param("productId") Long productId,
                  @Param("count") Integer count);
}
