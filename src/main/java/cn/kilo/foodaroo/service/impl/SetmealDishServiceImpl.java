package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.mapper.SetmealDishMapper;
import cn.kilo.foodaroo.mapper.SetmealMapper;
import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.pojo.SetmealDish;
import cn.kilo.foodaroo.service.SetmealDishService;
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
