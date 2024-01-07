package cn.kilo.foodraoo.dish.service.impl;

import cn.kilo.foodraoo.dish.mapper.SetmealDishMapper;
import cn.kilo.foodraoo.feign.pojo.SetmealDish;
import cn.kilo.foodraoo.dish.service.SetmealDishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * The SetmealDishServiceImpl class is a service implementation that provides methods to manage SetmealDish entities using a SetmealDishMapper instance.
 * It extends the ServiceImpl class and implements the SetmealDishService interface.
 * @see ServiceImpl
 * @see SetmealDishMapper
 * @see SetmealDish
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {
}
