package cn.kilo.foodraoo.dish.service;

import cn.kilo.foodraoo.dish.dto.DishDto;
import cn.kilo.foodraoo.feign.pojo.Dish;
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

    public void updateWithFlavor(DishDto dishDto);

    public void deleteWithFlavor(Long id);

}
