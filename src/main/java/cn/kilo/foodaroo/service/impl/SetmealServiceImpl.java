package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.dto.SetmealDto;
import cn.kilo.foodaroo.mapper.SetmealMapper;
import cn.kilo.foodaroo.pojo.DishFlavor;
import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.pojo.SetmealDish;
import cn.kilo.foodaroo.service.SetmealDishService;
import cn.kilo.foodaroo.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    /**
     * Get Setmeal With Dish List By Id
     * @param id
     * @return
     */
    @Override
    public SetmealDto getSetmealWithDishById(Long id){
        Setmeal setmeal = this.getById(id);
        Long setmealId = setmeal.getId();

        LambdaQueryWrapper<SetmealDish> setmealDishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealDishLambdaQueryWrapper.eq(SetmealDish::getSetmealId,setmealId);
        List<SetmealDish> setmealDishList = setmealDishService.list(setmealDishLambdaQueryWrapper);

        SetmealDto setmealDto = new SetmealDto();
        BeanUtils.copyProperties(setmeal,setmealDto);
        setmealDto.setSetmealDishes(setmealDishList);

        return setmealDto;
    }

    /**
     * Update a Setmeal and save setmeal-dish relation
     *
     * @param setmealDto
     */
    @Transactional
    @Override
    public void updateWithDish(SetmealDto setmealDto) {
        this.updateById(setmealDto);

        Long setmealId = setmealDto.getId();
        List<SetmealDish> setmealDishList = setmealDto.getSetmealDishes();

        setmealDishList.stream().forEach((SetmealDish setmealDish) -> {
            setmealDish.setSetmealId(setmealId);
        });


        setmealDishService.updateBatchById(setmealDishList);
        return;
    }


    /**
     * Delete Setmeal and the related Dishs in Setmeal_dish table
     * @param id
     */
    @Override
    public void deleteWithDish(Long id) {
        this.removeById(id);

        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SetmealDish::getSetmealId,id);
        setmealDishService.remove(lambdaQueryWrapper);

        return;
    }

}
