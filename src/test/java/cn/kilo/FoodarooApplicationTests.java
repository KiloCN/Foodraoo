package cn.kilo;

import cn.kilo.foodaroo.FoodarooApplication;
import cn.kilo.foodaroo.controller.EmployeeController;
import cn.kilo.foodaroo.pojo.Employee;
import cn.kilo.foodaroo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
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

        String path = "/Users/kilo.cn/Desktop/Code/Java/Foodraoo/Foodraoo/target/classes/static/backend/images/dish_pic/";
    }

}
