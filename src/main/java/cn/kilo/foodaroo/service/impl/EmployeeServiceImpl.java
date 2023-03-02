package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.mapper.EmployeeMapper;
import cn.kilo.foodaroo.pojo.Employee;
import cn.kilo.foodaroo.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * The EmployeeServiceImpl class is a service implementation that provides methods to manage Employee entities using a EmployeeMapper instance.
 * It extends the ServiceImpl class and implements the EmployeeService interface.
 * @see ServiceImpl
 * @see EmployeeService
 * @see EmployeeMapper
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService{
}
