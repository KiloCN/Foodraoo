package cn.kilo.foodaroo.service;

import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.pojo.SetmealDish;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;
/**
 * The SetmealDishService interface extends the IService interface to provide specific service methods for SetmealDish entities.
 * Its define how to handle the logic related services that manage SetmealDish entities.
 *
 * @see SetmealDish is the entity class that this service manages
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface SetmealDishService extends IService<SetmealDish> {
}
