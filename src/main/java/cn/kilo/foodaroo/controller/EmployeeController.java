package cn.kilo.foodaroo.controller;

import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.pojo.Employee;
import cn.kilo.foodaroo.service.EmployeeService;
import cn.kilo.foodaroo.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

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
        wrapper.eq(Employee::getUsername, employee.getUsername().trim());
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


    /**
     * Save A new Employee info
     * @param employee the employee info that need to be save
     * @return
     */
    @PostMapping
    public Result<String> saveEmployee(HttpServletRequest request, @RequestBody Employee employee){

        Long creatorEmployeeId = (Long) request.getSession().getAttribute("employeeId");
        String defaultPassword = DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8));

        employee.setUsername(employee.getUsername().trim());
        employee.setName(employee.getName().trim());
        employee.setPassword(defaultPassword);
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setCreateUser(creatorEmployeeId);
        employee.setUpdateUser(creatorEmployeeId);

        employeeService.save(employee);
        return Result.success("Save employee successfully");
    }


    /**
     * Get employee information list through pagination query
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public Result<Page<Employee>> getPage(@RequestParam("page") int page,
                                          @RequestParam("pageSize")int pageSize, String name) {
        if(name != null){
            name = name.trim();
        }
        Page pageInfo = new Page(page, pageSize);
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(StringUtil.isNotEmpty(name), Employee::getUsername, name);
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        Page pageResult = employeeService.page(pageInfo, queryWrapper);
        return Result.success(pageResult);
    }


    /**
     * Upate Employee info
     * @param request
     * @param employee
     * @return
     */
    @PutMapping()
    public Result<String> updateEmployee(HttpServletRequest request, @RequestBody Employee employee){
        Long updaterId = (Long) request.getSession().getAttribute("employeeId");
        employee.setUpdateUser(updaterId);
        employee.setUpdateTime(LocalDateTime.now());

        boolean updateResult = employeeService.updateById(employee);
        if(updateResult){
            return Result.success("Update Employee info successfully");
        }else{
            return Result.error("Update Employee info error");

        }
    }


    /**
     * Get Single Employee info through id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Employee> getEmployee(@PathVariable long id){
        Employee employee = employeeService.getById(id);
        if(employee != null){
            employee.setPassword("**");
            return Result.success(employee);
        }else {
            return Result.error("Can not find this employee whom id is:"+id);
        }
    }
}
