package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.dto.DishDto;
import cn.kilo.foodaroo.mapper.CategoryMapper;
import cn.kilo.foodaroo.mapper.DishMapper;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Dish;
import cn.kilo.foodaroo.pojo.DishFlavor;
import cn.kilo.foodaroo.service.DishFlavorService;
import cn.kilo.foodaroo.service.DishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The DishServiceImpl class is responsible for implementing the DishService interface and providing service methods related to Dish objects.
 * It extends the ServiceImpl class, which provides the basic CRUD operations.
 * This class uses the DishMapper to interact with the database and perform CRUD operations.
 * Additionally, this class provides a method to save a Dish object with its associated flavors by using the DishFlavorService to save the flavors to the database.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 * @see ServiceImpl
 * @see DishMapper
 * @see Dish
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * Saves a Dish object with its associated flavors to the database.
     * @param dishDto the DishDto object containing the Dish and its associated flavors
     */
    @Transactional
    @Override
    public void saveWithFlavor(DishDto dishDto) {
        this.save(dishDto);

        Long dishId = dishDto.getId();
        dishDto.getFlavors().stream().forEach((DishFlavor dishFlavor) -> {
            dishFlavor.setDishId(dishId);
        });
        dishFlavorService.saveBatch(dishDto.getFlavors());

    }
}
