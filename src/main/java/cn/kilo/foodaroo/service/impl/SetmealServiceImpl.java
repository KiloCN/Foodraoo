package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.mapper.DishMapper;
import cn.kilo.foodaroo.mapper.SetmealMapper;
import cn.kilo.foodaroo.pojo.Dish;
import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.service.SetmealService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * The SetmealServiceImpl class is a service implementation that provides methods to manage Setmeal entities using a SetmealMapper instance.
 * It extends the ServiceImpl class and implements the DishService interface.
 * @see ServiceImpl
 * @see SetmealMapper
 * @see Setmeal
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
