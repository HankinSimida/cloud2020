package cn.hankin.alibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hankin
 * @date 2020/4/1 0:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosMain84 {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain84.class,args);
    }
}
