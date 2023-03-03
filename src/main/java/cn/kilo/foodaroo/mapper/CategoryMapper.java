package cn.kilo.foodaroo.mapper;

import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * The CategoryMapper interface defines methods for accessing and manipulating category records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the category  table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
