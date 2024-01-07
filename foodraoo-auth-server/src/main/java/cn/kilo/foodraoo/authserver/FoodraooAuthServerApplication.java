package cn.kilo.foodraoo.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@EnableFeignClients
public class FoodraooAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodraooAuthServerApplication.class, args);
	}

}
