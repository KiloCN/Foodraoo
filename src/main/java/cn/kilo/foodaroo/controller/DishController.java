package cn.kilo.foodaroo.controller;

import cn.kilo.foodaroo.common.exception.BusinessException;
import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.dto.DishDto;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Dish;
import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.service.CategoryService;
import cn.kilo.foodaroo.service.DishFlavorService;
import cn.kilo.foodaroo.service.DishService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The DishController class is responsible for handling HTTP requests related to Dish.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;

    @Autowired
    private CategoryService categoryService;

    /**
     * Saves a new dish along with its flavors.
     *
     * @param request the HttpServletRequest object containing the HTTP request information.
     * @param dishDto the DishDto object containing the information about the new dish to be saved.
     * @return the Result object indicating the success of the operation.
     */
    @PostMapping
    public Result<String> saveDish(HttpServletRequest request, @RequestBody DishDto dishDto) {
        dishService.saveWithFlavor(dishDto);
        return Result.success("Save new dish successfully");
    }


    /**
     * Retrieves a paged list of dishes based on the given page number, page size, and dish name.
     * @param page the page number to retrieve.
     * @param pageSize the number of dishes to retrieve per page.
     * @param name the name of the dish to search for.
     * @return the Result object containing the paged list of dishes and metadata.
     */
    @GetMapping("/page")
    public Result<Page> getPage(int page, int pageSize, String name) {
        Page<Dish> pageInfo = new Page<>(page, pageSize);
        Page<DishDto> dishDtoPage = new Page<>();

        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.like(name != null, Dish::getName, name);
        queryWrapper.orderByDesc(Dish::getUpdateTime);


        Page<Dish> dishPage = dishService.page(pageInfo, queryWrapper);

        BeanUtils.copyProperties(pageInfo, dishDtoPage, "records");
        List<Dish> records = pageInfo.getRecords();
        List<DishDto> list = null;

        list = records.stream().map((item) -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item,dishDto);

            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            dishDto.setCategoryName(category.getName());

            return dishDto;
        }).collect(Collectors.toList());

        dishDtoPage.setRecords(list);
        return Result.success(dishDtoPage);

    }


    /**
     * This method retrieves a dish with the given ID, along with its flavors, if it exists.
     * @param id The id of Dish
     * @return
     */
    @GetMapping("/{id}")
    private Result<DishDto> getDishById(@PathVariable Long id){
        DishDto dishDto = dishService.getByIdWithFlavor(id);
        if(dishDto != null){
            return Result.success(dishDto);
        }else {
            return Result.error("Can not find the dish which  id is:"+id);
        }
    }


    /**
     * Update a new dish along with its flavors.
     *
     * @param request the HttpServletRequest object containing the HTTP request information.
     * @param dishDto the DishDto object containing the information about the new dish to be saved.
     * @return the Result object indicating the success of the operation.
     */
    @PutMapping
    public Result<String> updateDish(HttpServletRequest request, @RequestBody DishDto dishDto) {
        try {
            dishService.updateWithFlavor(dishDto);
        } catch (Exception e) {
            log.info(e.getMessage().toString());
            throw new BusinessException("Update dish occur error!");
        }
        return Result.success("Update dish successfully");
    }


    /**
     * Update the dish along with its flavors by id
     * @param ids
     * @return
     */
    @DeleteMapping("")
    public Result<String> deleteDish(Long ids){
        try {
            dishService.deleteWithFlavor(ids);
        } catch (Exception e) {
            log.info(e.getMessage().toString());
            throw new BusinessException("Delete dish occur error!");
        }
        return Result.success("Delete dish successfully");
    }


    /**
     * Get Dish list according to the condition
     * @param dish
     * @return
     */
    @GetMapping("/list")
    public Result<List<Dish>> getDishList(Dish dish){
        LambdaQueryWrapper<Dish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
        lambdaQueryWrapper.eq(Dish::getStatus,1);
        lambdaQueryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);

        List<Dish> list = dishService.list(lambdaQueryWrapper);
        return Result.success(list);
    }

    /**
     * Update the status of Dish
     * @param status
     * @param ids
     * @return
     */
    @PostMapping("/status/{status}")
    public Result<String> updateState(@PathVariable int status, Long ids){
        Dish dish = new Dish();
        dish.setId(ids);
        dish.setStatus(status);
        try {
            dishService.updateById(dish);
            return Result.success("Update status successfully.");
        } catch (Exception e) {
            log.info(e.getMessage().toString());
            return Result.error("Update status occur error!");
        }
    }
}
