package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.mapper.EmployeeMapper;
import cn.kilo.foodaroo.pojo.Employee;
import cn.kilo.foodaroo.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService{
}
