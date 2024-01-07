package cn.kilo.foodraoo.dish.service;

import cn.kilo.foodraoo.dish.dto.SetmealDto;
import cn.kilo.foodraoo.feign.pojo.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

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

    public SetmealDto getSetmealWithDishById(Long id);

    @Transactional
    void updateWithDish(SetmealDto setmealDto);

    void deleteWithDish(Long id);
}
