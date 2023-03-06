package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.common.BaseContext;
import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.dto.DishDto;
import cn.kilo.foodaroo.mapper.CategoryMapper;
import cn.kilo.foodaroo.mapper.DishMapper;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Dish;
import cn.kilo.foodaroo.pojo.DishFlavor;
import cn.kilo.foodaroo.service.DishFlavorService;
import cn.kilo.foodaroo.service.DishService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * Get Dish info with Flavor info by ID
     * @param id
     * @return
     */
    @Override
    public DishDto  getByIdWithFlavor(Long id) {
        DishDto dishDto = new DishDto();
        Dish dish = super.getById(id);
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(DishFlavor::getDishId,id);
        List<DishFlavor> dishFlavorList = dishFlavorService.list(queryWrapper);

        BeanUtils.copyProperties(dish,dishDto);
        dishDto.setFlavors(dishFlavorList);
        return dishDto;
    }

    /**
     * Update Dish info with Flavor info by ID
     * @param dishDto
     * @return
     */
    @Override
    public void updateWithFlavor(DishDto dishDto) {
        dishDto.setUpdateUser(BaseContext.getCurrentId());
        this.updateById(dishDto);

        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorService.remove(lambdaQueryWrapper);


        Long dishId = dishDto.getId();
        dishDto.getFlavors().stream().forEach((DishFlavor dishFlavor) -> {
            dishFlavor.setDishId(dishId);
        });
        dishFlavorService.saveBatch(dishDto.getFlavors());
        return;
    }

    /**
     * Delete Dish and the related Flavor
     * @param id
     */
    @Override
    public void deleteWithFlavor(Long id) {
        this.removeById(id);

        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(DishFlavor::getDishId,id);
        dishFlavorService.remove(lambdaQueryWrapper);

        return;
    }


}
