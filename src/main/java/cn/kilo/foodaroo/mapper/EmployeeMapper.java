package cn.kilo.foodaroo.mapper;

import cn.kilo.foodaroo.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * The EmployeeMapper interface defines methods for accessing and manipulating employee records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the employee table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
