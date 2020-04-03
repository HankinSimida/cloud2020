package cn.hankin.springcloud.alibaba.dao;

import cn.hankin.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hankin
 * @date 2020/4/2 1:07
 */
@Mapper
public interface OrderDao {
    void  create(Order order);
    void update(@Param("userId") Long userId , @Param("status") Integer status);
}
