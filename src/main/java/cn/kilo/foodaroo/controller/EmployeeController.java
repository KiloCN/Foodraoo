package cn.kilo.foodaroo.controller;

import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.pojo.Employee;
import cn.kilo.foodaroo.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * The EmployeeController class handles HTTP requests related to employee management.
 * It provides methods for employee login and logout.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    /**
     * Login an employee account using the provided username and password.
     *
     * @param request  the HTTP servlet request object.
     * @param employee the Employee object containing the username and password of the employee.
     * @return a Result object containing the logged-in Employee object, or an error message if the login failed.
     */
    @PostMapping("/login")
    public Result<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {

        if (employee.getPassword() == null) {
            return Result.error("Password can not be empty");
        }
        String md5Password = DigestUtils.md5DigestAsHex(employee.getPassword().getBytes(StandardCharsets.UTF_8));
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getUsername, employee.getUsername());
        Employee targetEmp = employeeService.getOne(wrapper);
        if (targetEmp == null) {
            return Result.error("The username does not exist, please register");
        }

        if (!md5Password.equals(targetEmp.getPassword())) {
            return Result.error("Password error, please try again");
        } else {
            if (targetEmp.getStatus() == 0) {
                return Result.error("This account has been disabled, please contact the administrator");
            } else {
                request.getSession().setAttribute("employeeId", targetEmp.getId());
                targetEmp.setPassword(null);
                return Result.success(targetEmp);
            }
        }
    }

    /**
     * Logout the currently logged-in employee account.
     *
     * @param request the HTTP servlet request object.
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("employeeId");
        return Result.success("Logout successfully");
    }
}
