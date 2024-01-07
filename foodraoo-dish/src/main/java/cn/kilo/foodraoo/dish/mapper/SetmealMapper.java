package cn.kilo.foodraoo.dish.mapper;

import cn.kilo.foodraoo.feign.pojo.Setmeal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * The SetmealMapper interface defines methods for accessing and manipulating Setmeal(Combo) records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the setmeal(combo)  table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {
}
