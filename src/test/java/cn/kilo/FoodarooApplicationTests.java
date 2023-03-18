package cn.kilo;

import cn.kilo.foodaroo.FoodarooApplication;
import cn.kilo.foodaroo.controller.EmployeeController;
import cn.kilo.foodaroo.pojo.Employee;
import cn.kilo.foodaroo.pojo.Orders;
import cn.kilo.foodaroo.service.EmployeeService;
import cn.kilo.foodaroo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.format.datetime.standard.DateTimeFormatterFactory;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest(classes = FoodarooApplication.class)
class FoodarooApplicationTests {

    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private Employee employee;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private OrderService orderService;


    @Test
    void contextLoads() {
        System.out.println(redisTemplate.opsForValue().get("ABC"));
//        System.out.println(redisTemplate.keys("*"));
    }

}
