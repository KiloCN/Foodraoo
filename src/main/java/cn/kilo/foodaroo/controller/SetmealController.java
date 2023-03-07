package cn.kilo.foodaroo.controller;


import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.dto.DishDto;
import cn.kilo.foodaroo.dto.SetmealDto;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.service.CategoryService;
import cn.kilo.foodaroo.service.SetmealDishService;
import cn.kilo.foodaroo.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private CategoryService categoryService;

    /**
     * Save new Setmeal with setmeal-dish relationship
     *
     * @param setmealDto
     * @return
     */
    @PostMapping
    public Result<String> saveSetmeal(@RequestBody SetmealDto setmealDto) {
        try {
            setmealService.saveWithDish(setmealDto);
            return Result.success("Save new Combo successful");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("Save Combo occur error");
        }
    }

    /**
     * Retrieves a paged list of Setmeal based on the given page number, page size, and Setmeal name.
     * @param page the page number to retrieve.
     * @param pageSize the number of dishes to retrieve per page.
     * @param name the name of the setmeal to search for.
     * @return the Result object containing the paged list of setmeal and metadata.
     */
    @GetMapping("/page")
    public Result<Page<SetmealDto>> getPage(int page, int pageSize, String name) {
//        log.info("page:"+page+" pageSize:"+pageSize+" name:"+name);
        Page<Setmeal> pageInfo = new Page<>(page, pageSize);


        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.like(name != null, Setmeal::getName, name);
        setmealLambdaQueryWrapper.orderByDesc(Setmeal::getUpdateTime);
        Page<Setmeal> setmealPage = setmealService.page(pageInfo, setmealLambdaQueryWrapper);

        Page<SetmealDto> dtoPage = new Page<>();
        BeanUtils.copyProperties(setmealPage, dtoPage,"records");

        List<Setmeal> setmealList = setmealPage.getRecords();
        List<SetmealDto> setmealDtoList = setmealList.stream().map((Setmeal setmeal) -> {
            SetmealDto setmealDto = new SetmealDto();
            BeanUtils.copyProperties(setmeal, setmealDto);
            Category category = categoryService.getById(setmeal.getCategoryId());
            if (category != null) {
                setmealDto.setCategoryName(category.getName());
            }
            return setmealDto;
        }).collect(Collectors.toList());

        dtoPage.setRecords(setmealDtoList);

        return Result.success(dtoPage);

    }
}
