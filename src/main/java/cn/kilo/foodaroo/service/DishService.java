package cn.kilo.foodaroo.service;

import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.dto.DishDto;
import cn.kilo.foodaroo.mapper.DishMapper;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The DishService interface extends the IService interface to provide specific service methods for Dish entities.
 * Its define how to handle the logic related services that manage Dish entities.
 *
 * @see Dish is the entity class that this service manages
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public interface DishService extends IService<Dish> {

    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);
}
