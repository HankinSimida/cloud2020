package cn.hankin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hankin
 * @date 2020/3/27 0:23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaMain9001.class,args);
    }
}
