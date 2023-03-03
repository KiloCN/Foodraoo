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
        employee.setId(1111L);
        boolean b = employeeService.updateById(employee);
        System.out.println(b);
    }

}
