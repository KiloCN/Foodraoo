package cn.kilo.foodraoo.dish.controller;


import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.common.exception.BusinessException;
import cn.kilo.foodraoo.dish.dto.SetmealDto;
import cn.kilo.foodraoo.feign.pojo.Category;
import cn.kilo.foodraoo.feign.pojo.Setmeal;
import cn.kilo.foodraoo.dish.service.CategoryService;
import cn.kilo.foodraoo.dish.service.SetmealDishService;
import cn.kilo.foodraoo.dish.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value = "setmealCache", allEntries = true)
    public Result<String> saveSetmeal(@RequestBody SetmealDto setmealDto) {
        try {
            setmealService.saveWithDish(setmealDto);
            return Result.success("Save new Combo successful");
        } catch (Exception e) {
            log.info(e.getMessage().toString());
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


    /**
     * This method retrieves a Setmeal with the given ID, along with its Dishs, if it exists.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SetmealDto> getSetmealById(@PathVariable Long id){
        SetmealDto setmealWithDishById = setmealService.getSetmealWithDishById(id);
        if (setmealWithDishById != null){
            return Result.success(setmealWithDishById);
        }else {
            return Result.error("This Setmeal ID was not found.");
        }
    }

    /**
     * Update a new Setmeal along with its Dishs.
     * @param setmealDto
     * @return
     */
    @PutMapping
    @CacheEvict(value = "setmealCache", allEntries = true)
    public Result<String> updateSetmeal(@RequestBody SetmealDto setmealDto){
        try {
            setmealService.updateWithDish(setmealDto);
            return Result.success("Update Setmeal successfully.");
        } catch (Exception e) {
            log.info(e.getMessage().toString());
            return Result.error("Occur error when updating!");
        }
    }


    /**
     * Delete Setmeal and the relation between Setmeal and Dishes.
     * @param ids
     * @return
     */
    @CacheEvict(value = "setmealCache", allEntries = true)
    @DeleteMapping
    public Result<String> deleteSetmeal(Long ids){
        try {
            setmealService.deleteWithDish(ids);
        } catch (Exception e) {
            log.info(e.getMessage().toString());
            throw new BusinessException("Delete Setmeal occur error!");
        }
        return Result.success("Delete Setmeal successfully");
    }


    /**
     * Update the status of Satmeal
     * @param status
     * @param ids
     * @return
     */
    @PostMapping("/status/{status}")
    @CacheEvict(value = "setmealCache", allEntries = true)
    public Result<String> updateState(@PathVariable int status, Long ids){
        Setmeal setmeal = new Setmeal();
        setmeal.setId(ids);
        setmeal.setStatus(status);
        try {
            setmealService.updateById(setmeal);
            return Result.success("Update status successfully.");
        } catch (Exception e) {
            log.info(e.getMessage().toString());
            return Result.error("Update status occur error!");
        }
    }


    /**
     * Query setmeal data according to conditions
     * @param setmeal
     * @return
     */
    @Cacheable(value = "setmealCache", key = "#setmeal.categoryId + '_' + #setmeal.status")
    @GetMapping("/list")
    public Result<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(setmeal.getCategoryId() != null,Setmeal::getCategoryId,setmeal.getCategoryId());
        queryWrapper.eq(setmeal.getStatus() != null,Setmeal::getStatus,setmeal.getStatus());
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);

        List<Setmeal> list = setmealService.list(queryWrapper);

        return Result.success(list);
    }
}