package cn.hankin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author hankin
 * @date 2020/3/24 0:12
 */
@SpringBootApplication
@EnableConfigServer
public class  MainAppConfigCenter3344{
    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigCenter3344.class,args);
    }
}
