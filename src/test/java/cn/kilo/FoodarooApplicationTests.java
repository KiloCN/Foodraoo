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
    private OrderService orderService;


    @Test
    void contextLoads() {
//        String source = "java.sql.SQLIntegrityConstraintViolationException: Duplicate entry 'Sea Food' for key 'idx_category_name'";
//        String regex = "Duplicate entry '([\\s\\S]*)' for key";
//
//        String redundantContent = "";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(source);
//        while (matcher.find()) {
//            redundantContent = matcher.group(1);
//        }
//        System.out.println(redundantContent);


//        String originalFilename = "lafasfa.png";
//        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//        System.out.println(fileSuffix);

//        String path = "/Users/kilo.cn/Desktop/Code/Java/Foodraoo/Foodraoo/target/classes/static/backend/images/dish_pic/";

        String time = "2023-03-06%2000%3A00%3A00";
//        Orders orders = orderService.getById(1633509698467917825L);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd%20HH%3Amm%3Ass");

//        System.out.println(orders.getOrderTime().toString());
//        System.out.println(LocalDateTime.now());
        time = time.replaceAll("%20","T").replaceAll("%3A",":");
        LocalDateTime parse = LocalDateTime.parse(time);
        System.out.println(parse);

    }

}
