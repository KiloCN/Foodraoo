package cn.kilo.foodaroo.mapper;

import cn.kilo.foodaroo.pojo.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * The DishMapper interface defines methods for accessing and manipulating Dish records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the dish table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
