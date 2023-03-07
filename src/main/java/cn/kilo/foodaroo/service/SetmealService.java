package cn.kilo.foodaroo.service;

import cn.kilo.foodaroo.dto.DishDto;
import cn.kilo.foodaroo.dto.SetmealDto;
import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.pojo.SetmealDish;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The SetmealService interface extends the IService interface to provide specific service methods for Setmeal entities.
 * Its define how to handle the logic related services that manage Setmeal entities.
 *
 * @see Setmeal is the entity class that this service manages
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);
}
