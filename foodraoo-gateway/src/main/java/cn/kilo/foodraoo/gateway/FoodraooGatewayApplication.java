package cn.kilo.foodraoo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FoodraooGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodraooGatewayApplication.class, args);
	}

}
