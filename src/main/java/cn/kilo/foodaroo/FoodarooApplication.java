package cn.kilo.foodaroo;

import  lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Startup class for the Foodaroo Web application.
 * This class is responsible for running the application.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class  FoodarooApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodarooApplication.class, args);
    }

}
