package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.dto.DishDto;
import cn.kilo.foodaroo.dto.SetmealDto;
import cn.kilo.foodaroo.mapper.DishMapper;
import cn.kilo.foodaroo.mapper.SetmealDishMapper;
import cn.kilo.foodaroo.mapper.SetmealMapper;
import cn.kilo.foodaroo.pojo.Dish;
import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.pojo.SetmealDish;
import cn.kilo.foodaroo.service.SetmealDishService;
import cn.kilo.foodaroo.service.SetmealService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The SetmealServiceImpl class is a service implementation that provides methods to manage Setmeal entities using a SetmealMapper instance.
 * It extends the ServiceImpl class and implements the SetmealService interface.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 * @see ServiceImpl
 * @see SetmealMapper
 * @see Setmeal
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * Add a Setmeal and save setmeal-dish relation
     *
     * @param setmealDto
     */
    @Transactional
    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        this.save(setmealDto);

        Long setmealId = setmealDto.getId();
        List<SetmealDish> setmealDishList = setmealDto.getSetmealDishes();

        setmealDishList.stream().forEach((SetmealDish setmealDish) -> {
            setmealDish.setSetmealId(setmealId);
        });


        setmealDishService.saveBatch(setmealDishList);
        return;
    }
}
