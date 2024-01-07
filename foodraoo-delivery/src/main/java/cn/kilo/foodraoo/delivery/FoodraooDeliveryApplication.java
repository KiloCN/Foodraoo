package cn.kilo.foodraoo.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@ServletComponentScan(basePackages = "cn.kilo.foodraoo.delivery.controller.filter")
@EnableRedisHttpSession //Enable Redis Session
@EnableTransactionManagement
//@EnableCaching
@EnableDiscoveryClient
@EnableFeignClients(defaultConfiguration = cn.kilo.foodraoo.feign.config.DefaultFeignConfiguration.class,
        basePackages = {"cn.kilo.foodraoo.feign.client"})
public class FoodraooDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodraooDeliveryApplication.class, args);
    }

}
