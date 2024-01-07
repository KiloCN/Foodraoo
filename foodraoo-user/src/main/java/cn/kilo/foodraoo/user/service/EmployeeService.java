package cn.kilo.foodraoo.user.service;

import cn.kilo.foodraoo.feign.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The EmployeeService interface extends the IService interface to provide specific service methods for Employee entities.
 * Its define how to handle the logic related services that manage Employee entities.
 *
 * @see Employee is the entity class that this service manages
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public interface EmployeeService extends IService<Employee> {
}
