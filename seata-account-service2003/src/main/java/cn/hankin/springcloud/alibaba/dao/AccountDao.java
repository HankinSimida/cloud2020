package cn.hankin.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author hankin
 * @date 2020/4/4 15:52
 */
@Mapper
public interface AccountDao {
    void decrease(@Param("userId")Long userId, @Param("money")BigDecimal money);
}
