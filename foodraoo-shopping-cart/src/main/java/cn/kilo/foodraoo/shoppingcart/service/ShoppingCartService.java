package cn.kilo.foodraoo.shoppingcart.service;

import cn.kilo.foodraoo.feign.pojo.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * The ShoppingCartService interface extends the IService interface to provide specific service methods for ShoppingCart entities.
 * Its define how to handle the logic related services that manage ShoppingCart entities.
 *
 * @see ShoppingCart is the entity class that this service manages
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public interface ShoppingCartService extends IService<ShoppingCart> {

    public List<ShoppingCart> getShoppingCartListByUserId(Long userId);

    public boolean deleteShoppingCartByUserId(Long userId);
}
