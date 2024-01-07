package cn.kilo.foodraoo.dish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan(basePackages = "cn.kilo.foodraoo.dish.controller.filter")
@EnableRedisHttpSession //Enable Redis Session
@EnableTransactionManagement
//@EnableCaching
@EnableDiscoveryClient
@EnableFeignClients
public class FoodraooDishApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodraooDishApplication.class, args);
    }

}
