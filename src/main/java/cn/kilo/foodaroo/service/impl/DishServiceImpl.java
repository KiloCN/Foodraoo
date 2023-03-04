package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.mapper.CategoryMapper;
import cn.kilo.foodaroo.mapper.DishMapper;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Dish;
import cn.kilo.foodaroo.service.DishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * The DishServiceImpl class is a service implementation that provides methods to manage Dish entities using a DishMapper instance.
 * It extends the ServiceImpl class and implements the DishService interface.
 * @see ServiceImpl
 * @see DishMapper
 * @see Dish
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
