package cn.kilo.foodraoo.dish.mapper;

import cn.kilo.foodraoo.feign.pojo.SetmealDish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * The SetmealDishMapper interface defines methods for accessing and manipulating setmeal_dish records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the setmeal_dish table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface SetmealDishMapper extends BaseMapper<SetmealDish> {
}
