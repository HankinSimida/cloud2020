package cn.hankin.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hankin
 * @date 2020/4/4 16:05
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消数据源自动创建
public class AccountServiceMain2003 {
    public static void main(String[] args) {
        SpringApplication.run((AccountServiceMain2003.class),args);
    }
}
