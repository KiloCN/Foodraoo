package cn.kilo.foodaroo.controller;


import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.dto.DishDto;
import cn.kilo.foodaroo.dto.SetmealDto;
import cn.kilo.foodaroo.service.SetmealDishService;
import cn.kilo.foodaroo.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The SetmealController class is responsible for handling HTTP requests related to Setmeal.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmealController {

    @Autowired
    private SetmealService setmealService;
    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * Save new Setmeal with setmeal-dish relationship
     * @param setmealDto
     * @return
     */
    @PostMapping
    public Result<String> saveSetmeal(@RequestBody SetmealDto setmealDto){
        try {
            setmealService.saveWithDish(setmealDto);
            return Result.success("Save new Combo successful");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("Save Combo occur error");
        }
    }
}
