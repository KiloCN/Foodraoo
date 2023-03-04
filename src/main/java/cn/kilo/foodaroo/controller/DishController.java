package cn.kilo.foodaroo.controller;

import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.common.ThreadLocalUserId;
import cn.kilo.foodaroo.dto.DishDto;
import cn.kilo.foodaroo.service.DishFlavorService;
import cn.kilo.foodaroo.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
/**
 * The DishController class is responsible for handling HTTP requests related to Dish.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * Saves a new dish along with its flavors.
     *
     * @param request the HttpServletRequest object containing the HTTP request information.
     * @param dishDto the DishDto object containing the information about the new dish to be saved.
     * @return the Result object indicating the success of the operation.
     */
    @PostMapping
    public Result<String> saveDish(HttpServletRequest request, @RequestBody DishDto dishDto){
        Long createrId = (Long) request.getSession().getAttribute("employeeId");
        ThreadLocalUserId.setUserId(createrId);
        dishService.saveWithFlavor(dishDto);
        return Result.success("Save new dish successfully");
    }
}
