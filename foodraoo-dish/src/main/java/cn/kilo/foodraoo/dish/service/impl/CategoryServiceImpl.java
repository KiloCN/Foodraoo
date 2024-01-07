package cn.kilo.foodraoo.dish.service.impl;

import cn.kilo.foodraoo.common.exception.BusinessException;
import cn.kilo.foodraoo.dish.mapper.CategoryMapper;
import cn.kilo.foodraoo.feign.pojo.Category;
import cn.kilo.foodraoo.feign.pojo.Dish;
import cn.kilo.foodraoo.feign.pojo.Setmeal;
import cn.kilo.foodraoo.dish.service.CategoryService;
import cn.kilo.foodraoo.dish.service.DishService;
import cn.kilo.foodraoo.dish.service.SetmealService;
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
        long relatedDishesCount = dishService.count(dishLambdaQueryWrapper);
        if(relatedDishesCount > 0){
            throw new BusinessException("The selected Category is associated with Dishes and cannot be deleted");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        long relatedSetmealCount = setmealService.count(setmealLambdaQueryWrapper);
        if(relatedSetmealCount > 0){
            throw new BusinessException("The selected Category is associated with Combo and cannot be deleted");
        }
        super.removeById(id);
    }
}
