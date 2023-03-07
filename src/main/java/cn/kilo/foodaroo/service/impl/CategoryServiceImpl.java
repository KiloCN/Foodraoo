package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.common.exception.BusinessException;
import cn.kilo.foodaroo.mapper.CategoryMapper;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Dish;
import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.service.CategoryService;
import cn.kilo.foodaroo.service.DishService;
import cn.kilo.foodaroo.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The CategoryServiceImpl class is a service implementation that provides methods to manage Category entities using a CategoryMapper instance.
 * It extends the ServiceImpl class and implements the CategoryService interface.
 * @see ServiceImpl
 * @see CategoryMapper
 * @see Category
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    
    
    /**
     * Delete a Category based on the id,
     * Should check whether the Category is associated with a Setmeal(Combo) or Dish
     * @param id
     */
    @Override
    public void removeCategoryById(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<Dish>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int relatedDishesCount = dishService.count(dishLambdaQueryWrapper);
        if(relatedDishesCount > 0){
            throw new BusinessException("The selected Category is associated with Dishes and cannot be deleted");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int relatedSetmealCount = setmealService.count(setmealLambdaQueryWrapper);
        if(relatedSetmealCount > 0){
            throw new BusinessException("The selected Category is associated with Combo and cannot be deleted");
        }
        super.removeById(id);
    }
}
