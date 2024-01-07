package cn.kilo.foodraoo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan(basePackages = "cn.kilo.foodraoo.user.controller.filter")
@EnableCaching
@EnableDiscoveryClient
@EnableRedisHttpSession //Enable Redis Session
@EnableFeignClients(defaultConfiguration = cn.kilo.foodraoo.feign.config.DefaultFeignConfiguration.class
    ,basePackages = "cn.kilo.foodraoo.feign.client")
@ComponentScan({"cn.kilo.foodraoo.user", "cn.kilo.foodraoo.common"})
public class FoodraooUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodraooUserApplication.class, args);
    }

}
