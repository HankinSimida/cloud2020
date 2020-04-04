package cn.hankin.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hankin
 * @date 2020/4/3 23:56
 */
@Configuration
@MapperScan({"cn.hankin.springcloud.alibaba.dao"})
public class MybatisConfig {
}
