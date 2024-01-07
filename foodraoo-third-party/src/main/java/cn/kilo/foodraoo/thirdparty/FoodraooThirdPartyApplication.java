package cn.kilo.foodraoo.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableFeignClients(defaultConfiguration = cn.kilo.foodraoo.feign.config.DefaultFeignConfiguration.class)
public class FoodraooThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodraooThirdPartyApplication.class, args);
    }

}
