package cn.kilo.foodraoo.dish.mapper;

import cn.kilo.foodraoo.feign.pojo.DishFlavor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * The DishFlavorMapper interface is responsible for mapping the DishFlavor objects to the database using MyBatis.
 * It extends the BaseMapper interface, which provides the basic CRUD operations.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {
}
