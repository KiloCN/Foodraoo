package cn.kilo.foodraoo.feign.client;

import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.feign.pojo.ShoppingCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "foodraoo-shopping-cart")
public interface ShoppingCartClient {
    @GetMapping("/shoppingCart/getShoppingCartListByUserId")
    public Result<List<ShoppingCart>> getShoppingCartListByUserId(@RequestParam("userId") Long userId);

    @DeleteMapping("/shoppingCart/deleteShoppingCartByUserId")
    public Result<String> deleteShoppingCartByUserId(@RequestParam("userId") Long userId);
}
