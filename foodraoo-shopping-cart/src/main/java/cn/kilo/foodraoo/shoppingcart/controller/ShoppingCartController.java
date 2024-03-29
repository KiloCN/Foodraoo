package cn.kilo.foodraoo.shoppingcart.controller;

import cn.kilo.foodraoo.common.BaseContext;
import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.feign.pojo.ShoppingCart;
import cn.kilo.foodraoo.shoppingcart.service.ShoppingCartService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * The ShoppingCartController class is a RESTful controller that handles shopping cart related operations.
 * It contains methods for adding, listing, and emptying shopping carts.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Slf4j
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * Add shopping cart
     * @param shoppingCart
     * @return
     */
    @PostMapping("/add")
    public Result<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart){
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);

        Long dishId = shoppingCart.getDishId();

        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,currentId);

        if(dishId != null){
            queryWrapper.eq(ShoppingCart::getDishId,dishId);

        }else{
            queryWrapper.eq(ShoppingCart::getSetmealId,shoppingCart.getSetmealId());
        }

        //SQL:select * from shopping_cart where user_id = ? and dish_id/setmeal_id = ?
        ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);

        if(cartServiceOne != null){
            Integer number = cartServiceOne.getNumber();
            cartServiceOne.setNumber(number + 1);
            shoppingCartService.updateById(cartServiceOne);
        }else{
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.save(shoppingCart);
            cartServiceOne = shoppingCart;
        }

        return Result.success(cartServiceOne);
    }

    /**
     * View the shopping cart
     * @return
     */
    @GetMapping("/list")
    public Result<List<ShoppingCart>> list(){

        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        queryWrapper.orderByAsc(ShoppingCart::getCreateTime);

        List<ShoppingCart> list = shoppingCartService.list(queryWrapper);

        return Result.success(list);
    }

    /**
     * Empty the shopping cart
     * @return
     */
    @DeleteMapping("/clean")
    public Result<String> clean(){
        //SQL:delete from shopping_cart where user_id = ?

        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());

        shoppingCartService.remove(queryWrapper);

        return Result.success("Emptying shopping cart successfully");
    }

    /**
     * Reduce count or remove of a dish/setmeal in user's shopping cart
     *
     * @param map
     * @return
     */
    @PostMapping("/sub")
    public Result<String> sub(@RequestBody Map map){
        Long currentId = BaseContext.getCurrentId();
        LambdaQueryWrapper<ShoppingCart> shoppingCartLambdaQueryWrapper = new LambdaQueryWrapper<>();


        String setmealId = (String) map.get("setmealId");
        String dishId =  (String) map.get("dishId");




        shoppingCartLambdaQueryWrapper.eq(ShoppingCart::getUserId,currentId);
        shoppingCartLambdaQueryWrapper.eq(setmealId != null, ShoppingCart::getSetmealId, setmealId)
                .eq(dishId != null, ShoppingCart::getDishId, dishId);
        ShoppingCart shoppingCart = shoppingCartService.getOne(shoppingCartLambdaQueryWrapper);


       if(shoppingCart.getNumber() != 1){
           shoppingCart.setNumber(shoppingCart.getNumber()-1);
           shoppingCartService.updateById(shoppingCart);

       }else {
           shoppingCartService.removeById(shoppingCart);
       }


       return Result.success("Sub successful");
    }


    @GetMapping("/getShoppingCartListByUserId")
    public Result<List<ShoppingCart>> getShoppingCartListByUserId(@RequestParam("userId") Long userId) {
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        log.info("Shopping Cart query userId:{}",userId);
        queryWrapper.eq(ShoppingCart::getUserId,userId);
        queryWrapper.orderByAsc(ShoppingCart::getCreateTime);

        List<ShoppingCart> list = shoppingCartService.list(queryWrapper);

        return Result.success(list);
    }


    @DeleteMapping("/deleteShoppingCartByUserId")
    public Result<String> deleteShoppingCartByUserId(@RequestParam("userId") Long userId) {
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,userId);

        if (shoppingCartService.remove(queryWrapper)) {
            return Result.success("Delete shopping cart successfully!");
        } else {
            return Result.error("Delete shopping cart failed!");
        }
    }
}